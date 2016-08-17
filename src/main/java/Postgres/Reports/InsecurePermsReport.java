package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class InsecurePermsReport {
    public static void getInsecurePerms(List<Reports> reportsList) {
        String domainName;
        JSONArray suspicious;
        JSONArray malicious;
        Integer suspicious_count = 0;
        Integer malicious_count = 0;
        System.out.println("################# INSECURE PERMISSIONS REPORT ####################");
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
            try {
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                System.out.println("SUSPICIOUS FILES:");
                suspicious = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
                for (Object files : suspicious) {
                    JSONObject file = new JSONObject(files.toString());
                    System.out.println("FILE: " + file.getString("path") + "           Perms: " + file.getString("perms"));
                    suspicious_count ++;
                }
                System.out.println("Suspicious files found: " + suspicious_count);
                suspicious_count = 0;
                System.out.println("MALICIOUS FILES:");
                malicious = reputation.getJSONObject("scanned_files_malicious").getJSONArray("files");
                for (Object files : malicious) {
                    JSONObject file = new JSONObject(files.toString());
                    System.out.println("FILE: " + file.getString("path") + "           Perms: " + file.getString("perms"));
                    malicious_count ++;
                }
                System.out.println("Malicious files found: " + malicious_count);
                malicious_count =0;
                System.out.println("##########################################");
            } catch (JSONException e){}
        }
    }
}
