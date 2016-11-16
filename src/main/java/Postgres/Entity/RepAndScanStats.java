package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 11.11.16.
 */
public class RepAndScanStats {
    public static final String FIELD_SSL_ISSUES = "ssl_issues";
    public static final String FIELD_IS_BLACKLISTED = "is_blacklisted";
//    public static final String FIELD_WEBINSPECTOR_STAT = "webinspector_stat";
    public static final String FIELD_PHISHING_DETECTED = "phishing_detected";
    public static final String FIELD_REPUTATION_LAST_SCAN_DATE = "reputation_last_scan_date";
    public static final String FIELD_MALWARE_DETECTED = "malware_detected";
    public static final String FIELD_INJECTED_CODE_FOUND = "injected_code_found";
    public static final String FIELD_INSECURE_PERMISSIONS ="insecure_permissions";
    public static final String FIELD_MALWARE_LAST_SCAN_DATE = "malware_last_scan_date";

    public Boolean ssl_issues;
    public Boolean is_blacklisted;
    public Boolean phishing_detected;
    public Boolean malware_detected;
    public Boolean injected_code_found;
    public Boolean insecure_permissions;
    public Timestamp reputation_last_scan_date;
    public Timestamp malware_last_scan_date;

    public RepAndScanStats(Boolean ssl_issues, Boolean is_blacklisted, Boolean phishing_detected, Boolean malware_detected,
                           Boolean injected_code_found, Boolean insecure_permissions, Timestamp reputation_last_scan_date,
                           Timestamp malware_last_scan_date) {
        this.ssl_issues = ssl_issues;
        this.is_blacklisted = is_blacklisted;
        this.phishing_detected = phishing_detected;
        this.malware_detected = malware_detected;
        this.injected_code_found = injected_code_found;
        this.insecure_permissions = insecure_permissions;
        this.reputation_last_scan_date = reputation_last_scan_date;
        this.malware_last_scan_date = malware_last_scan_date;
    }
}
