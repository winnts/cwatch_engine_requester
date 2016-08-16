package Postgres.Entity;

/**
 * Created by adyachenko on 16.08.16.
 */
public class Reports {
    public static final String TABLE = "reports";
    public static final String FIELD_ID = "id";
    public static final String FIELD_DOMAIN_ID = "domain_id";
    public static final String FIELD_VERDICT = "verdict";
    public static final String FIELD_MALWARE_DESCRIPTION = "malware_description";
    public static final String FIELD_REPUTATION_DESCRIPTION = "reputation_description";
    public static final String FIELD_MALWARE_DETECTED = "malware_detected";
    public static final String FIELD_PHISHING_DETECTED = "phishing_detected";
    public static final String FIELD_IS_BLACKLISTED = "is_blacklisted";
    public static final String FIELD_SSL_ISSUES = "ssl_issues";
    public static final String FIELD_INJECTED_CODE_FOUND = "injected_code_found";
    public static final String FIELD_INSECURE_PERMISSIONS = "insecure_permissions";

    public Integer getId;
    public Integer getFieldDomain_id;
    public String getFieldVerdict;
    public String getFieldMalwareDescription;
    public String getFieldReputationDescription;
    public Boolean getFieldMalwareDetected;
    public Boolean getFieldPhishingDetected;
    public Boolean getFieldIsBlacklisted;
    public Boolean getFieldSslIssues;
    public Boolean getFieldInjectedCodeFound;
    public Boolean getFieldInsecurePermissions;

    public Reports(int getId, int getFieldDomain_id, String getFieldVerdict, String getFieldMalwareDescription, String getFieldReputationDescription,
                   Boolean getFieldMalwareDetected, Boolean getFieldPhishingDetected, Boolean getFieldIsBlacklisted, Boolean getFieldSslIssues,
                   Boolean getFieldInjectedCodeFound, Boolean getFieldInsecurePermissions){
        this.getId = getId;
        this.getFieldDomain_id = getFieldDomain_id;
        this.getFieldVerdict = getFieldVerdict;
        this.getFieldMalwareDescription = getFieldMalwareDescription;
        this.getFieldReputationDescription = getFieldReputationDescription;
        this.getFieldMalwareDetected = getFieldMalwareDetected;
        this.getFieldPhishingDetected = getFieldPhishingDetected;
        this.getFieldIsBlacklisted = getFieldIsBlacklisted;
        this.getFieldSslIssues = getFieldSslIssues;
        this.getFieldInjectedCodeFound = getFieldInjectedCodeFound;
        this.getFieldInsecurePermissions = getFieldInsecurePermissions;

    }


    @Override
    public String toString() {
        return "{\"Reports\":{"
                + "\"getId\":\"" + getId + "\""
                + ", \"getFieldDomain_id\":\"" + getFieldDomain_id + "\""
                + ", \"getFieldVerdict\":\"" + getFieldVerdict + "\""
                + ", \"getFieldMalwareDescription\":\"" + getFieldMalwareDescription + "\""
                + ", \"getFieldReputationDescription\":\"" + getFieldReputationDescription + "\""
                + ", \"getFieldMalwareDetected\":\"" + getFieldMalwareDetected + "\""
                + ", \"getFieldPhishingDetected\":\"" + getFieldPhishingDetected + "\""
                + ", \"getFieldIsBlacklisted\":\"" + getFieldIsBlacklisted + "\""
                + ", \"getFieldSslIssues\":\"" + getFieldSslIssues + "\""
                + ", \"getFieldInjectedCodeFound\":\"" + getFieldInjectedCodeFound + "\""
                + ", \"getFieldInsecurePermissions\":\"" + getFieldInsecurePermissions + "\""
                + "}}";
    }
}
