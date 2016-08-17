package Postgres.Reports;

import Postgres.Entity.Licenses;

import java.util.List;

/**
 * Created by adyachenko on 17.08.16.
 */
public class LicensesByType {
    public static void getLicensesByType(List<Licenses> licensesList) {
        String domainName;
        String licensesKey;
        System.out.println("################# LICENSES BY TYPE REPORT ####################");
//        System.out.println(licensesList);
        for (Licenses licenses : licensesList) {
            String licensesRep = licenses.getFieldKey;
            System.out.println(licensesRep);

//            try {
//                licensesKey = licensesRep.getJSONObject("ssl_details").getJSONObject("ssl_issues").getString("details");
//                System.out.println("SSL_ISSUE: " + sslIssue);
//                System.out.println("##########################################");
//            } catch (JSONException e) {}
        }
    }
}
