package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class SslReport {
    public static void getSSLIssues(List<Reports> reportsList) {
        String domainName;
        String sslIssue;
        System.out.println("################# SSL REPORT ####################");
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
            domainName = reputation.getString("domain");
            System.out.println("DOMAIN: " + domainName);
            sslIssue = reputation.getJSONObject("ssl_details").getJSONObject("ssl_issues").getString("details");
            System.out.println("SSL_ISSUE: " + sslIssue);
            System.out.println("##########################################");
        }
    }
}
