package Postgres;

import Postgres.Entity.Domains;
import Postgres.Entity.LicensesPermits;
import Postgres.Reports.LicensesAndDomains;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.select;
import static Postgres.Constants.DbConst.selectAll;
import static Postgres.Constants.DbConst.where;

/**
 * Created by adyachenko on 17.08.16.
 */
public class GetLicensesPermits {
    public static List<LicensesPermits> collectFields(String sql) throws SQLException {
        List<LicensesPermits> ret = new ArrayList<LicensesPermits>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
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
            }
                catch (SQLException e){
                    e.printStackTrace();}
                }
        return ret;
    }

    public static List<LicensesPermits> requestLicensesByDomainID (Integer domain) throws SQLException{
        String sql = selectAll + LicensesPermits.TABLE + where + LicensesPermits.FIELD_CLIENTABLE_ID + "=" + domain +";";
        return collectFields(sql);
    }

    public static List<LicensesPermits> requestLicensesPerDomain() throws SQLException{
        String sql = selectAll + LicensesPermits.TABLE + where + LicensesPermits.FIELD_CLIENTABLE_TYPE + "=" + "\'Domain\'" +";";
        return collectFields(sql);
    }

    public static List<LicensesPermits> requestLicensesPerDomainAndHost(Integer hostId) throws SQLException{
        String sql = selectAll + LicensesPermits.TABLE + where + LicensesPermits.FIELD_CLIENTABLE_TYPE + "=" + "\'Domain\'" +
                " AND " + LicensesPermits.FIELD_CLIENTABLE_ID + " IN " + "(" + select + Domains.FIELD_ID + " FROM " +
                Domains.TABLE + " WHERE " + Domains.FIELD_HOST_ID +"=" + hostId + ");";
        return collectFields(sql);
    }

    public static void main(String[] args) throws SQLException {
        LicensesAndDomains.getLicensesAll(requestLicensesPerDomainAndHost(2));
    }
}
