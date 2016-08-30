package Postgres;

import Postgres.Entity.Domains;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.selectAll;
import static Postgres.Constants.DbConst.selectId;
import static Postgres.Constants.DbConst.where;

/**
 * Created by adyachenko on 15.08.16.
 */
public class GetDomains {
    public static List<Domains> collectFields(ResultSet rs) throws SQLException {
        List<Domains> ret = new ArrayList<Domains>();
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
        return ret;
    }

    public static List<Domains> getDomain() throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Domains.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Domains> getDomain(String domain) throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Domains.TABLE + where + Domains.FIELD_DOMAIN + "=\'" + domain + "\';");
        return collectFields(rs);
    }

    public static Integer getDomainIdByName (String domain) throws SQLException {
        Integer domain_id = null;
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectId + Domains.TABLE +
                where + Domains.FIELD_DOMAIN + "='" + domain + "';");
        while (rs.next()) {
            domain_id = rs.getInt("id");
        }
        return domain_id;
    }

    public static String getDomainNameById (Integer id) throws SQLException {
        String domain_name = "";
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Domains.TABLE +
                where + Domains.FIELD_ID + "=" + id +";");
        while (rs.next()) {
            domain_name = rs.getString("domain");
        }
        return domain_name;
    }

    public static void main(String[] args) throws SQLException {
//        System.out.println(getDomainNameById(1023));
        System.out.println(getDomain());
        GetPostgresConn.statement().close();
    }
}