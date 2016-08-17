package Postgres;

import Postgres.Entity.Licenses;
import Postgres.Reports.LicensesByType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.selectAll;
import static Postgres.Constants.DbConst.where;

/**
 * Created by adyachenko on 17.08.16.
 */
public class GetLicenses {
    public static List<Licenses> collectFields(ResultSet rs) throws SQLException {
        List<Licenses> ret = new ArrayList<Licenses>();
        while (rs.next()) {
            Licenses licenses = new Licenses(
                    rs.getInt(Licenses.FIELD_ID),
                    rs.getString(Licenses.FIELD_KEY),
                    rs.getInt(Licenses.FIELD_LICENSE_STATUS_ID),
                    rs.getTimestamp(Licenses.FIELD_CREATED_AT),
                    rs.getTimestamp(Licenses.FIELD_UPDATED_AT),
                    rs.getString(Licenses.FIELD_KIND),
                    rs.getString(Licenses.FIELD_TITLE),
                    rs.getString(Licenses.FIELD_PRODUCT),
                    rs.getTimestamp(Licenses.FIELD_EXPIRED_AT),
                    rs.getInt(Licenses.FIELD_CAPT_POINTS)
            );
            ret.add(licenses);
        }
        return ret;
    }

    public static List<Licenses> requestAllLicenses() throws SQLException{
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Licenses.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Licenses> requestLicensesByType(String type) throws SQLException{
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Licenses.TABLE +
                where + Licenses.FIELD_PRODUCT + "=" + "\'" + type + "\';");
        return collectFields(rs);
    }

    public static void main(String[] args) throws SQLException {
        LicensesByType.getLicensesByType(requestLicensesByType("capt.domain_free.free"));
    }
}