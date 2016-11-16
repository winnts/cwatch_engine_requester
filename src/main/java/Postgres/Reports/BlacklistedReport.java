package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class BlacklistedReport {
    public static void getBlacklisted(List<Reports> reportsList) {
        String domainName;
        String blacklisted;
        System.out.println("################# BLACKLISTED REPORT ####################");
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldReputationDescription);
            try {
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                System.out.println("Comodo Webinspector : " + reputation.getJSONObject("blacklisted_details").getJSONObject("comodo_webinspector").getBoolean("hit"));
                System.out.println("GSB : " + reputation.getJSONObject("blacklisted_details").getJSONObject("gsb").getBoolean("hit"));
                System.out.println("##########################################");
            } catch (JSONException e) {}
        }
    }
    public static Boolean getBlacklistedStatus (List<Reports> reportsList){
        return reportsList.get(0).getFieldIsBlacklisted;
    }
}
