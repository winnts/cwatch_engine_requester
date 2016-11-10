package Postgres.Reports;

import Postgres.Entity.*;
import Postgres.GetPostgresConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.*;
/**
 * Created by adyachenko on 10.11.16.
 */
public class GetLicensesByHost {
    public static List<LicensesByHost> collectFields(String sql) throws SQLException {
        List<LicensesByHost> ret = new ArrayList<LicensesByHost>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LicensesByHost reports = new LicensesByHost(
                            rs.getString(Domains.FIELD_DOMAIN),
                            rs.getString(Licenses.FIELD_KEY),
                            rs.getString(Licenses.FIELD_PRODUCT),
                            rs.getInt(Licenses.FIELD_LICENSE_STATUS_ID),
                            rs.getTimestamp(Licenses.FIELD_EXPIRED_AT)
                    );
                    ret.add(reports);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
    public static List<LicensesByHost> getLicensesByHosts(Integer host_id) throws SQLException {
        String sql = select + Domains.TABLE+"."+Domains.FIELD_DOMAIN + "," + Licenses.TABLE+"."+Licenses.FIELD_KEY +","
                            + Licenses.TABLE+"."+Licenses.FIELD_PRODUCT +"," + Licenses.TABLE + "." + Licenses.FIELD_LICENSE_STATUS_ID+","
                            + Licenses.TABLE+"."+Licenses.FIELD_EXPIRED_AT
                   + from + LicensesPermits.TABLE
                   + innerJoin + Domains.TABLE + on + LicensesPermits.TABLE+"."+LicensesPermits.FIELD_CLIENTABLE_ID+"="+Domains.TABLE+"."+Domains.FIELD_ID
                   + innerJoin + Licenses.TABLE + on + Licenses.TABLE+"."+Licenses.FIELD_ID+"="+LicensesPermits.TABLE+"."+LicensesPermits.FIELD_LICENSE_ID
                   + where + LicensesPermits.FIELD_CLIENTABLE_TYPE+"="+"\'Domain\'"
                   + and + Domains.TABLE+"."+Domains.FIELD_HOST_ID+"="+host_id;
        return collectFields(sql);
    }
}
