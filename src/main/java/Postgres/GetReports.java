package Postgres;

import Postgres.Entity.Reports;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 16.08.16.
 */
public class GetReports {

    public static List<Reports> collectFields (ResultSet rs) throws SQLException {
        List<Reports> ret = new ArrayList<Reports>();
        while (rs.next()) {
                Reports reports = new Reports(
                        rs.getInt(Reports.FIELD_ID),
                        rs.getInt(Reports.FIELD_DOMAIN_ID),
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
        return ret;
    }

    public static List<Reports> requestAllReports (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestSSLIssues (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + " WHERE " + Reports.FIELD_SSL_ISSUES + "=TRUE;");
        return collectFields(rs);
    }

    public static void getSSLIssues (Statement statement) {
        String domainName;
        String sslIssue;
        System.out.println("################# SSL REPORT ####################");
        try {
            for (Reports reports : requestSSLIssues(statement)) {
                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                sslIssue = reputation.getJSONObject("ssl_details").getJSONObject("ssl_issues").getString("details");
                System.out.println("SSL_ISSUE: " + sslIssue);
                System.out.println("##########################################");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Reports> requestMalware (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + " WHERE " + Reports.FIELD_MALWARE_DETECTED + "=TRUE;");
        return collectFields(rs);
    }


    public static List<Reports> requestPhishing (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + " WHERE " + Reports.FIELD_PHISHING_DETECTED + "=TRUE;");
        return collectFields(rs);
    }
    public static void getPhishing (Statement statement) {
        String domainName;
        String phishing;
        System.out.println("################# PHISHING REPORT ####################");
        try {
            for (Reports reports : requestPhishing(statement)) {
                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                System.out.println("Phishtank : " + reputation.getJSONObject("phishing_details").getJSONObject("phishtank").getString("url"));
                System.out.println("GSB : " + reputation.getJSONObject("phishing_details").getJSONObject("gsb").getBoolean("hit"));
                System.out.println("##########################################");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Reports> requestBlacklisted (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + " WHERE " + Reports.FIELD_IS_BLACKLISTED + "=TRUE;");
        return collectFields(rs);
    }

    public static void getBlacklisted (Statement statement) {
        String domainName;
        String blacklisted;
        System.out.println("################# BLACKLISTED REPORT ####################");
        try {
            for (Reports reports : requestBlacklisted(statement)) {
                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                System.out.println("Comodo Webinspector : " + reputation.getJSONObject("blacklisted_details").getJSONObject("comodo_webinspector").getBoolean("hit"));
                System.out.println("GSB : " + reputation.getJSONObject("blacklisted_details").getJSONObject("gsb").getBoolean("hit"));
                System.out.println("##########################################");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Reports> requestInjected (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + " WHERE " + Reports.FIELD_INJECTED_CODE_FOUND + "=TRUE;");
        return collectFields(rs);
    }


    public static List<Reports> requestIsecurePerms (Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Reports.TABLE + " WHERE " + Reports.FIELD_INSECURE_PERMISSIONS + "=TRUE;");
        return collectFields(rs);
    }

    public static void getInsecurePerms (Statement statement) {
        String domainName;
        JSONArray malware;
        System.out.println("################# MALWARE REPORT ####################");
        try {
            for (Reports reports : requestIsecurePerms(statement)) {
                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
//                System.out.println(reports.getFieldMalwareDescription);
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
                for (Object files : malware) {
                    JSONObject file = new JSONObject(files.toString());
                    System.out.println("FILE: " + file.getString("path") + " Perms: " + file.getString("perms"));
                }
                System.out.println("##########################################");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        GetPostgresConn conn = new GetPostgresConn();
        Statement statement = conn.stmt();
//        getSSLIssues(statement);
//        getMalware(statement);
//        getPhishing(statement);
//        getBlacklisted(statement);
        getInsecurePerms(statement);
        statement.close();

    }
}
