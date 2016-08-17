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
        for (Licenses licenses : licensesList) {
            System.out.println("License key: " + licenses.getFieldKey);
        }
    }
}
