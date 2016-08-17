package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 17.08.16.
 */
public class LicensesPermits {
    public static final String TABLE = "licenses_permits";
    public static final String FIELD_ID = "id";
    public static final String FIELD_LICENSE_ID = "license_id";
    public static final String FIELD_CLIENTABLE_ID = "clientable_id";
    public static final String FIELD_CLIENTABLE_TYPE = "clientable_type";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";

    public Integer getFieldId;
    public Integer getFieldLicenseId;
    public Integer getFieldClientableId;
    public String getFieldClientableType;
    public Timestamp getFieldCreatedAt;
    public Timestamp getFieldUpdatedAt;

    public LicensesPermits(Integer getFieldId, Integer getFieldLicenseId, Integer getFieldClientableId, String getFieldClientableType, Timestamp getFieldCreatedAt, Timestamp getFieldUpdatedAt) {
        this.getFieldId = getFieldId;
        this.getFieldLicenseId = getFieldLicenseId;
        this.getFieldClientableId = getFieldClientableId;
        this.getFieldClientableType = getFieldClientableType;
        this.getFieldCreatedAt = getFieldCreatedAt;
        this.getFieldUpdatedAt = getFieldUpdatedAt;
    }

    @Override
    public String toString() {
        return "{\"LicensesPermits\":{"
                + "\"getFieldId\":\"" + getFieldId + "\""
                + ", \"getFieldLicenseId\":\"" + getFieldLicenseId + "\""
                + ", \"getFieldClientableId\":\"" + getFieldClientableId + "\""
                + ", \"getFieldClientableType\":\"" + getFieldClientableType + "\""
                + ", \"getFieldCreatedAt\":" + getFieldCreatedAt
                + ", \"getFieldUpdatedAt\":" + getFieldUpdatedAt
                + "}}";
    }
}
