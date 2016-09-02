package Postgres;

import Postgres.Entity.Licenses;
import Postgres.Reports.LicensesAll;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static String LICENSE_FREE = "capt.domain_free.free";
    public static String LICENSE_PROTECTED = "capt.domain_protected";
    public static String LICENSE_FULLY_MANAGEMENT = "capt.domainfully.management";

    public static List<Licenses> collectFields(String sql) throws SQLException {
        List<Licenses> ret = new ArrayList<Licenses>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            return ret;
        }


        public static List<Licenses> requestAllLicenses ()throws SQLException {
            String sql = selectAll + Licenses.TABLE + ";";
            return collectFields(sql);
        }

        public static List<Licenses> requestLicensesByType (String type)throws SQLException {
            String sql = selectAll + Licenses.TABLE + where + Licenses.FIELD_PRODUCT + "=" + "\'" + type + "\';";
            return collectFields(sql);
        }

        public static List<Licenses> requestLicensesById (Integer id)throws SQLException {
            String sql = selectAll + Licenses.TABLE + where + Licenses.FIELD_ID + "=" + id + ";";
            return collectFields(sql);
        }

        public static void main (String[]args)throws SQLException {
//        LicensesByType.getLicensesByType(requestLicensesByType(LICENSE_FREE));
            LicensesAll.getLicensesAll(requestAllLicenses());

        }
    }