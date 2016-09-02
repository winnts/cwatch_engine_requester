package Postgres;

import Postgres.Entity.Domains;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.*;

/**
 * Created by adyachenko on 15.08.16.
 */
public class GetDomains {
    public static List<Domains> collectFields(String sql) throws SQLException {
        List<Domains> ret = new ArrayList<Domains>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Domains reports = new Domains(
                            rs.getInt(Domains.FIELD_ID),
                            rs.getString(Domains.FIELD_SLUG),
                            rs.getString(Domains.FIELD_OWNER),
                            rs.getString(Domains.FIELD_IPV6),
                            rs.getString(Domains.FIELD_IP),
                            rs.getString(Domains.FIELD_SUSPENDTIME),
                            rs.getString(Domains.FIELD_IS_LOCKED),
                            rs.getString(Domains.FIELD_SUSPENDREASON),
                            rs.getString(Domains.FIELD_EMAIL),
                            rs.getString(Domains.FIELD_DOMAIN),
                            rs.getString(Domains.FIELD_SUSPENDED),
                            rs.getString(Domains.FIELD_UNIX_STARDATE),
                            rs.getString(Domains.FIELD_USER),
                            rs.getString(Domains.FIELD_PLAN),
                            rs.getString(Domains.FIELD_SHELL),
                            rs.getString(Domains.FIELD_PARTITION),
                            rs.getString(Domains.FIELD_THEME),
                            rs.getInt(Domains.FIELD_HOST_ID),
                            rs.getString(Domains.FIELD_SITE_OWNER_ID),
                            rs.getTimestamp(Domains.FIELD_CREATED_AT),
                            rs.getTimestamp(Domains.FIELD_UPDATED_AT),
                            rs.getInt(Domains.FIELD_STATUS_ID),
                            rs.getString(Domains.FIELD_DIR),
                            rs.getString(Domains.FIELD_IS_PARENT),
                            rs.getString(Domains.FIELD_ROOTDOMAIN),
                            rs.getString(Domains.FIELD_IS_SUBDOMAIN),
                            rs.getString(Domains.FIELD_IS_ADDONDOMAIN)
                    );
                    ret.add(reports);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static List<Domains> getDomain() throws SQLException {
        String sql = selectAll + Domains.TABLE + ";";
        return collectFields(sql);
    }

    public static List<Domains> getDomain(String domain) throws SQLException {
        String sql = selectAll + Domains.TABLE + where + Domains.FIELD_DOMAIN + "=\'" + domain + "\';";
        return collectFields(sql);
    }

    public static Integer getDomainIdByName(String domain) throws SQLException {
        Integer domain_id = null;
        String sql = selectAll + Domains.TABLE + where + Domains.FIELD_DOMAIN + "='" + domain + "';";
            for (Domains domainid : collectFields(sql)){
                domain_id = domainid.getFieldId;
            }
        return domain_id;
    }

    public static String getDomainNameById(Integer id) throws SQLException {
        String domain_name = "";
        String sql = selectAll + Domains.TABLE + where + Domains.FIELD_ID + "=" + id + ";";
        for (Domains domainname : collectFields(sql)){
            domain_name = domainname.getFieldDomain;
        }
        return domain_name;
    }

    public static void main(String[] args) throws SQLException {
//        System.out.println(getDomainNameById(1023));
        System.out.println(getDomain());
//        GetPostgresConn.statement().close();
    }
}