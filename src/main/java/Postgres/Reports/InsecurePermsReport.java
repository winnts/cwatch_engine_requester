package Postgres.Reports;

import Postgres.Entity.Reports;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrey.Dyachenko on 16.08.16.
 */
public class InsecurePermsReport {
    public static void getInsecurePerms(List<Reports> reportsList) {
        String domainName;
        JSONArray suspicious;
        JSONArray malicious;
        System.out.println("################# INSECURE PERMISSIONS REPORT ####################");
        for (Reports reports : reportsList) {
            JSONObject reputation = new JSONObject(reports.getFieldMalwareDescription);
            try {
                domainName = reputation.getString("domain");
                System.out.println("DOMAIN: " + domainName);
                Long timeFromJSON = reputation.getLong("last_scan_date");

//                Timestamp timestamp = new Timestamp(timeFromJSON);
//                System.out.println(timestamp);
                Date getDate = new Date(timeFromJSON * 1000);

                System.out.println("Last scan date: " + getDate);

                System.out.println("SUSPICIOUS FILES:");
                suspicious = reputation.getJSONObject("scanned_files_suspicious").getJSONArray("files");
                Integer suspicious_count = 0;
                for (Object files : suspicious) {
                    JSONObject file = new JSONObject(files.toString());
                    System.out.println("FILE: " + file.getString("path") + "           Perms: " + file.getString("perms"));
                    suspicious_count ++;
                }
                System.out.println("Suspicious files found: " + suspicious_count);
                System.out.println("MALICIOUS FILES:");
                malicious = reputation.getJSONObject("scanned_files_malicious").getJSONArray("files");
                Integer malicious_count = 0;
                for (Object files : malicious) {
                    JSONObject file = new JSONObject(files.toString());
                    System.out.println("FILE: " + file.getString("path") + "           Perms: " + file.getString("perms"));
                    malicious_count ++;
                }
                System.out.println("Malicious files found: " + malicious_count);
                System.out.println("##########################################");
            } catch (JSONException e) {
                e.printStackTrace();

            }
        }
    }
}
