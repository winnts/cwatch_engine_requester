package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class InjectedReport {
    public static void getInjected(List<Reports> reportsList) {
        String domainName;
        JSONArray malware;
        System.out.println("################# INJECTED CODE REPORT ####################");
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
            try {
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                malware = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
                for (Object files : malware) {
                    JSONObject file = new JSONObject(files.toString());
                    System.out.println("FILE: " + file.getString("path") + "           Detected by: " + file.getString("detected_by"));
                }
                System.out.println("##########################################");
            } catch (JSONException e) {
            }
        }
    }
}
