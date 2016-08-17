package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class SslReport {
    public static void getSSLIssues(List<Reports> reportsList) {
        String domainName;
        String sslIssue;
        System.out.println("################# SSL REPORT ####################");
        System.out.println(reportsList);
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
            try {
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                sslIssue = reputation.getJSONObject("ssl_details").getJSONObject("ssl_issues").getString("details");
                System.out.println("SSL_ISSUE: " + sslIssue);
                System.out.println("##########################################");
            } catch (JSONException e) {}
        }
    }
}
