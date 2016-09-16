package Postgres;

import Postgres.Entity.Reports;
import Postgres.Reports.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.*;

/**
 * Created by adyachenko on 16.08.16.
 */
public class GetReports {

    public static List<Reports> collectFields(String sql) throws SQLException {
        List<Reports> ret = new ArrayList<Reports>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reports reports = new Reports(
                            rs.getInt(Reports.FIELD_ID),
                            rs.getInt(Reports.FIELD_DOMAIN_ID),
                            rs.getTimestamp(Reports.FIELD_CREATED_AT),
                            rs.getTimestamp(Reports.FIELD_UPDATED_AT),
                            rs.getString(Reports.FIELD_VERDICT),
                            rs.getString(Reports.FIELD_MALWARE_DESCRIPTION),
                            rs.getString(Reports.FIELD_REPUTATION_DESCRIPTION),
                            rs.getBoolean(Reports.FIELD_MALWARE_DETECTED),
                            rs.getBoolean(Reports.FIELD_PHISHING_DETECTED),
                            rs.getBoolean(Reports.FIELD_IS_BLACKLISTED),
                            rs.getBoolean(Reports.FIELD_SSL_ISSUES),
                            rs.getBoolean(Reports.FIELD_INJECTED_CODE_FOUND),
                            rs.getBoolean(Reports.FIELD_INSECURE_PERMISSIONS)
                    );
                    ret.add(reports);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static List<Reports> requestAllReports() throws SQLException {
        String sql = selectAll + Reports.TABLE + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestSSLIssues() throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_SSL_ISSUES + "=" + isTrue + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestSSLIssues(Integer id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + id + ";";
        return collectFields(sql);
    }


    public static List<Reports> requestMalware() throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_MALWARE_DETECTED + "=" + isTrue + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestMalware(Integer id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + id + ";";
        return collectFields(sql);
    }


    public static List<Reports> requestPhishing() throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_PHISHING_DETECTED + "=" + isTrue + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestPhishing(Integer id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + id + ";";
        return collectFields(sql);
    }


    public static List<Reports> requestBlacklisted() throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_IS_BLACKLISTED + "=" + isTrue +";";
        return collectFields(sql);
    }

    public static List<Reports> requestBlacklisted(Integer id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + id + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestInjected() throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_INJECTED_CODE_FOUND + "=" + isTrue + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestInjected(Integer id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + id + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestIsecurePerms() throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_INSECURE_PERMISSIONS + "=" + isTrue + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestIsecurePerms(Integer id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + id + ";";
        return collectFields(sql);
    }

    public static List<Reports> requestReportByDomainId(Integer domain_id) throws SQLException {
        String sql = selectAll + Reports.TABLE + where + Reports.FIELD_DOMAIN_ID + "=" + domain_id + ";";
        return collectFields(sql);
    }

    public static void getFullReportByDomainName(String domain) throws SQLException {
        SslReport.getSSLIssues(requestSSLIssues(GetDomains.getDomainIdByName(domain)));
        BlacklistedReport.getBlacklisted(requestBlacklisted(GetDomains.getDomainIdByName(domain)));
        InjectedReport.getInjected(requestInjected(GetDomains.getDomainIdByName(domain)));
        InsecurePermsReport.getInsecurePerms(requestIsecurePerms(GetDomains.getDomainIdByName(domain)));
        MalwareReport.getMalware(requestMalware(GetDomains.getDomainIdByName(domain)));
        PhishingReport.getPhishing(requestPhishing(GetDomains.getDomainIdByName(domain)));
    }


    public static void main(String[] args) throws SQLException {
/* Usage :
        SslReport.getSSLIssues(requestSSLIssues()); //Get all domains with SSL issues
        MalwareReport.getMalware(requestMalware(GetDomains.getDomainIdByName(domain))); //Get Malware Report by Domain Name
        InjectedReport.getInjected(requestInjected(292)); //Get Injected Report By Domain ID
        getFullReportByDomainName("gumblar.cn"); //Get Full Report By Domain Name
*/
//        MalwareReport.getMalware(requestMalware());
//        InjectedReport.getInjected(requestInjected());
//        GetPostgresConn.statement().close();
//        InsecurePermsReport.getInsecurePerms(requestIsecurePerms());
//        getFullReportByDomainName("gumblar.cn");
        SslReport.getSSLIssues(requestSSLIssues());

    }
}
