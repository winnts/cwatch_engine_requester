package Postgres;

import Postgres.Entity.LicensesPermits;
import Postgres.Reports.LicensesAndDomains;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.selectAll;
import static Postgres.Constants.DbConst.where;

/**
 * Created by adyachenko on 17.08.16.
 */
public class GetLicensesPermits {
    public static List<LicensesPermits> collectFields(ResultSet rs) throws SQLException {
        List<LicensesPermits> ret = new ArrayList<LicensesPermits>();
        while (rs.next()) {
            LicensesPermits reports = new LicensesPermits(
                    rs.getInt(LicensesPermits.FIELD_ID),
                    rs.getInt(LicensesPermits.FIELD_LICENSE_ID),
                    rs.getInt(LicensesPermits.FIELD_CLIENTABLE_ID),
                    rs.getString(LicensesPermits.FIELD_CLIENTABLE_TYPE),
                    rs.getTimestamp(LicensesPermits.FIELD_CREATED_AT),
                    rs.getTimestamp(LicensesPermits.FIELD_UPDATED_AT)
            );
            ret.add(reports);
        }
        return ret;
    }

    public static List<LicensesPermits> requestLicensesByDomainID (Integer domain) throws SQLException{
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + LicensesPermits.TABLE +
                where + LicensesPermits.FIELD_CLIENTABLE_ID + "=" + domain +";");
        return collectFields(rs);
    }

    public static List<LicensesPermits> requestLicensesPerDomain() throws SQLException{
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + LicensesPermits.TABLE +
                where + LicensesPermits.FIELD_CLIENTABLE_TYPE + "=" + "\'Domain\'" +";");
        return collectFields(rs);
    }

    public static List<LicensesPermits> requestLicensesPerDomainAndHost(Integer hostId) throws SQLException{
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + LicensesPermits.TABLE +
                where + LicensesPermits.FIELD_CLIENTABLE_TYPE + "=" + "\'Domain\'" + " AND " + ";");
        return collectFields(rs);
    }

    public static void main(String[] args) throws SQLException {
        LicensesAndDomains.getLicensesAll(requestLicensesPerDomain());
    }
}
