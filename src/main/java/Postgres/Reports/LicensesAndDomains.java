package Postgres.Reports;

import Postgres.Entity.Licenses;
import Postgres.Entity.LicensesByHost;
import Postgres.Entity.LicensesPermits;
import Postgres.GetDomains;
import Postgres.GetLicenses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 18.08.16.
 */
public class LicensesAndDomains {
    public static List<LicensesByHost> getLicensesAll(List<LicensesPermits> licensesPermitsList) throws SQLException {
        List<LicensesByHost> ret = new ArrayList<LicensesByHost>();
        for (LicensesPermits licensesPermits : licensesPermitsList) {
            List<Licenses> licenses = GetLicenses.requestLicensesById(licensesPermits.getFieldLicenseId);
            for (Licenses license : licenses) {
                LicensesByHost licensesByHost = new LicensesByHost(
                        GetDomains.getDomainNameById(licensesPermits.getFieldClientableId),
                        license.getFieldKey,
                        license.getFieldProduct,
                        license.getFieldLicenseStatusId,
                        license.getFieldExpiredAt);
                ret.add(licensesByHost);
            }
        }
        return ret;
    }

}
