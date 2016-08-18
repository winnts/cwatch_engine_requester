package Postgres.Reports;

import Postgres.Entity.Licenses;
import Postgres.Entity.LicensesPermits;
import Postgres.GetDomains;
import Postgres.GetLicenses;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by adyachenko on 18.08.16.
 */
public class LicensesAndDomains {
    public static void getLicensesAll(List<LicensesPermits> licensesPermitsList) throws SQLException {
        System.out.println("################# LICENSES PER DOMAINS REPORT ####################");
        for (LicensesPermits licensesPermits : licensesPermitsList) {
            List<Licenses> licenses = GetLicenses.requestLicensesById(licensesPermits.getFieldLicenseId);
            for (Licenses license : licenses) {
                System.out.println("Domain: " + GetDomains.getDomainNameById(licensesPermits.getFieldClientableId) +
                        "    License Key: " + license.getFieldKey + "     Product: " + license.getFieldProduct);
            }
        }
        System.out.println("################# ####################### ####################");
    }
}
