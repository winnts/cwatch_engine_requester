package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class PhishingReport {
    public static void getPhishing(List<Reports> reportsList) {
        String domainName;
        String phishing;
        System.out.println("################# PHISHING REPORT ####################");
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
            try {
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                System.out.println("Phishtank : " + reputation.getJSONObject("phishing_details").getJSONObject("phishtank").getString("url"));
                System.out.println("GSB : " + reputation.getJSONObject("phishing_details").getJSONObject("gsb").getBoolean("hit"));
                System.out.println("##########################################");
            } catch (JSONException e) {}
        }
    }
}
