package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 01.09.16.
 */
public class LicensesByHost {
    public static final String FIELD_DOMAIN = "domain";
    public static final String FIELD_LICENSE_KEY = "license_key";
    public static final String FIELD_PRODUCT = "product";
    public static final String FIELD_LICENSE_STATUS_ID="license_status_id";
    public static final String FIELD_EXPIRED_AT = "expired_at";

    public String domain;
    public String license_key;
    public String product;
    public Integer license_status_id;
    public Timestamp expired_at;

    public LicensesByHost(String domain, String license_key, String product, Integer license_status_id, Timestamp expired_at) {
        this.domain = domain;
        this.license_key = license_key;
        this.product = product;
        this.license_status_id = license_status_id;
        this.expired_at = expired_at;
    }
}
