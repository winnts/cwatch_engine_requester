package Postgres;

import Postgres.Entity.Domains;
import Postgres.Entity.Reports;
import Postgres.Reports.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.*;

/**
 * Created by adyachenko on 16.08.16.
 */
public class GetReports {

    public static Statement statement() throws SQLException {
        Statement statement = new GetPostgresConn().connectToProd().createStatement();
        return statement;
    }

    public static List<Reports> collectFields(ResultSet rs) throws SQLException {
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

    public static List<Reports> requestAllReports() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestSSLIssues() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_SSL_ISSUES + "=" + isTrue + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestSSLIssues(Integer id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_DOMAIN_ID + "=" + id + ";");
        return collectFields(rs);
    }

//    public static void getSSLIssues() {
//        String domainName;
//        String sslIssue;
//        System.out.println("################# SSL REPORT ####################");
//        try {
//            for (Reports reports : requestSSLIssues()) {
//                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                sslIssue = reputation.getJSONObject("ssl_details").getJSONObject("ssl_issues").getString("details");
//                System.out.println("SSL_ISSUE: " + sslIssue);
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Reports> requestMalware() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_MALWARE_DETECTED + "=" + isTrue + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestMalware(Integer id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_DOMAIN_ID + "=" + id + ";");
        return collectFields(rs);
    }

//    public static void getMalware() {
//        String domainName;
//        JSONArray malware;
//        System.out.println("################# MALWARE REPORT ####################");
//        try {
//            for (Reports reports : requestMalware()) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
//                System.out.println(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
//                for (Object files : malware) {
//                    JSONObject file = new JSONObject(files.toString());
//                    System.out.println("FILE: " + file.getString("path") + " Perms: " + file.getString("perms"));
//                }
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Reports> requestPhishing() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_PHISHING_DETECTED + "=" + isTrue + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestPhishing(Integer id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_DOMAIN_ID + "=" + id + ";");
        return collectFields(rs);
    }

//    public static void getPhishing() {
//        String domainName;
//        String phishing;
//        System.out.println("################# PHISHING REPORT ####################");
//        try {
//            for (Reports reports : requestPhishing()) {
//                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                System.out.println("Phishtank : " + reputation.getJSONObject("phishing_details").getJSONObject("phishtank").getString("url"));
//                System.out.println("GSB : " + reputation.getJSONObject("phishing_details").getJSONObject("gsb").getBoolean("hit"));
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Reports> requestBlacklisted() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE + 
                where + Reports.FIELD_IS_BLACKLISTED + "=" + isTrue +";");
        return collectFields(rs);
    }

    public static List<Reports> requestBlacklisted(Integer id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE +
                where + Reports.FIELD_DOMAIN_ID + "=" + id + ";");
        return collectFields(rs);
    }

//    public static void getBlacklisted() {
//        String domainName;
//        String blacklisted;
//        System.out.println("################# BLACKLISTED REPORT ####################");
//        try {
//            for (Reports reports : requestBlacklisted()) {
//                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                System.out.println("Comodo Webinspector : " + reputation.getJSONObject("blacklisted_details").getJSONObject("comodo_webinspector").getBoolean("hit"));
//                System.out.println("GSB : " + reputation.getJSONObject("blacklisted_details").getJSONObject("gsb").getBoolean("hit"));
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Reports> requestInjected() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE +
                where + Reports.FIELD_INJECTED_CODE_FOUND + "=" + isTrue + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestInjected(Integer id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE +
                where + Reports.FIELD_DOMAIN_ID + "=" + id + ";");
        return collectFields(rs);
    }

//    public static void getInjected() {
//        String domainName;
//        JSONArray malware;
//        System.out.println("################# INJECTED CODE REPORT ####################");
//        try {
//            for (Reports reports : requestInjected()) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
////                System.out.println(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
//                for (Object files : malware) {
//                    JSONObject file = new JSONObject(files.toString());
//                    System.out.println("FILE: " + file.getString("path") + "           Detected by: " + file.getString("detected_by"));
//                }
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public static List<Reports> requestIsecurePerms() throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE +
                where + Reports.FIELD_INSECURE_PERMISSIONS + "=" + isTrue + ";");
        return collectFields(rs);
    }

    public static List<Reports> requestIsecurePerms(Integer id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE +
                where + Reports.FIELD_DOMAIN_ID + "=" + id + ";");
        return collectFields(rs);
    }

//    public static void getInsecurePerms() {
//        String domainName;
//        JSONArray malware;
//        System.out.println("################# INSECURE PERMISSIONS REPORT ####################");
//        try {
//            for (Reports reports : requestIsecurePerms()) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
////                System.out.println(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
//                for (Object files : malware) {
//                    JSONObject file = new JSONObject(files.toString());
//                    System.out.println("FILE: " + file.getString("path") + "           Perms: " + file.getString("perms"));
//                }
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Reports> requestReportByDomainId(Integer domain_id) throws SQLException {
        ResultSet rs = statement().executeQuery(selectAll + Reports.TABLE +
                where + Reports.FIELD_DOMAIN_ID + "=" + domain_id + ";");
        return collectFields(rs);
    }

//    public static void getReportByDomainId(Integer domain_id) {
//        String domainName;
//        JSONArray malware;
//        System.out.println("################# REPORT BY DOMAIN ID ####################");
//        try {
//            for (Reports reports : requestReportByDomainId(domain_id)) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
//                System.out.println(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                System.out.println("##########################################");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static Integer getReportByDomain(String domain) throws SQLException {
        Integer domain_id = null;
        ResultSet rs = statement().executeQuery("SELECT id FROM " + Domains.TABLE +
                where + Domains.FIELD_DOMAIN + "='" + domain + "';");
        while (rs.next()) {
            domain_id = rs.getInt("id");
        }
        return domain_id;
    }


    public static void getFullReportByDomainName(String domain) throws SQLException {
//        String domainName;
//        String sslIssue;
//        JSONArray malware;
//        try {
//            System.out.println("########### SSL REPORT ##############");
//            for (Reports reports : requestSSLIssues(getReportByDomain(domain))) {
//                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                sslIssue = reputation.getJSONObject("ssl_details").getJSONObject("ssl_issues").getString("details");
//                System.out.println("SSL_ISSUE: " + sslIssue);
//                System.out.println("##########################################");
//            }
//            System.out.println("########### MALWARE REPORT ##############");
//            for (Reports reports : requestMalware(getReportByDomain(domain))) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
////                System.out.println(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
//                for (Object files : malware) {
//                    JSONObject file = new JSONObject(files.toString());
//                    System.out.println("FILE: " + file.getString("path") + " Perms: " + file.getString("perms"));
//                }
//                System.out.println("##########################################");
//            }
//            System.out.println("################## PHISHING REPORT ########################");
//            for (Reports reports : requestPhishing(getReportByDomain(domain))) {
//                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                System.out.println("Phishtank : " + reputation.getJSONObject("phishing_details").getJSONObject("phishtank").getString("url"));
//                System.out.println("GSB : " + reputation.getJSONObject("phishing_details").getJSONObject("gsb").getBoolean("hit"));
//                System.out.println("##########################################");
//            }
//            System.out.println("########### BLACKLISTED REPORT ##############");
//            for (Reports reports : requestBlacklisted(getReportByDomain(domain))) {
//                JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                System.out.println("Comodo Webinspector : " + reputation.getJSONObject("blacklisted_details").getJSONObject("comodo_webinspector").getBoolean("hit"));
//                System.out.println("GSB : " + reputation.getJSONObject("blacklisted_details").getJSONObject("gsb").getBoolean("hit"));
//                System.out.println("##########################################");
//            }
//            System.out.println("########### INJECTED CODE REPORT ##############");
//            for (Reports reports : requestInjected(getReportByDomain(domain))) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
//                for (Object files : malware) {
//                    JSONObject file = new JSONObject(files.toString());
//                    System.out.println("FILE: " + file.getString("path") + "           Detected by: " + file.getString("detected_by"));
//                }
//                System.out.println("##########################################");
//            }
//            System.out.println("########### INSECURED PERMS REPORT ##############");
//            for (Reports reports : requestIsecurePerms(getReportByDomain(domain))) {
//                JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
////                System.out.println(reports.getFieldMalwareDescription);
//                domainName = reputation.getString("domain");
//                System.out.println("DOMAIN: " + domainName);
//                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
//                for (Object files : malware) {
//                    JSONObject file = new JSONObject(files.toString());
//                    System.out.println("FILE: " + file.getString("path") + "           Perms: " + file.getString("perms"));
//                }
//                System.out.println("##########################################");
//            }
//
//
//
//        } catch (SQLException e) {e.printStackTrace();}
        SslReport.getSSLIssues(requestSSLIssues(getReportByDomain(domain)));
        BlacklistedReport.getBlacklisted(requestBlacklisted(getReportByDomain(domain)));
        InjectedReport.getInjected(requestInjected(getReportByDomain(domain)));
        InsecurePermsReport.getInsecurePerms(requestIsecurePerms(getReportByDomain(domain)));
        MalwareReport.getMalware(requestMalware(getReportByDomain(domain)));
        PhishingReport.getPhishing(requestPhishing(getReportByDomain(domain)));
    }


    public static void main(String[] args) throws SQLException {
//        getSSLIssues();
//        getMalware();
//        getPhishing();
//        getBlacklisted();
//        getInsecurePerms();
//        getInjected();
//        getReportByDomainId(292);
//        getReportByDomain("gumblar.cn");
//        generateFullReport("gumblar.cn");
        SslReport.getSSLIssues(requestSSLIssues()); //Get all domains with SSL issues
        MalwareReport.getMalware(requestMalware(getReportByDomain("gumblar.cn"))); //Get Malware Report by Domain name
        InjectedReport.getInjected(requestInjected(292)); //Get Injected Report By Domain ID
        statement().close();

    }
}
