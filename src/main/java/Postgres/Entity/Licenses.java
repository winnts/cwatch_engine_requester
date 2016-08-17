package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 17.08.16.
 */
public class Licenses {
    public static final String TABLE = "licenses";
    public static final String FIELD_ID = "id";
    public static final String FIELD_KEY = "key";
    public static final String FIELD_LICENSE_STATUS_ID = "license_status_id";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";
    public static final String FIELD_KIND = "kind";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_PRODUCT = "product";
    public static final String FIELD_EXPIRED_AT = "expired_at";
    public static final String FIELD_CAPT_POINTS = "capt_points";

    public Integer getFieldId;
    public String getFieldKey;
    public Integer getFieldLicenseStatusId;
    public Timestamp getFieldCreatedAt;
    public Timestamp getFieldUpdatedAt;
    public String getFieldKind;
    public String getFieldTitle;
    public String getFieldProduct;
    public Timestamp getFieldExpiredAt;
    public Integer getFieldCaptPoints;

    public Licenses(Integer getFieldId, String getFieldKey, Integer getFieldLicenseStatusId, Timestamp getFieldCreatedAt,
                    Timestamp getFieldUpdatedAt, String getFieldKind, String getFieldTitle, String getFieldProduct,
                    Timestamp getFieldExpiredAt, Integer getFieldCaptPoints) {
        this.getFieldId = getFieldId;
        this.getFieldKey = getFieldKey;
        this.getFieldLicenseStatusId = getFieldLicenseStatusId;
        this.getFieldCreatedAt = getFieldCreatedAt;
        this.getFieldUpdatedAt = getFieldUpdatedAt;
        this.getFieldKind = getFieldKind;
        this.getFieldTitle = getFieldTitle;
        this.getFieldProduct = getFieldProduct;
        this.getFieldExpiredAt = getFieldExpiredAt;
        this.getFieldCaptPoints = getFieldCaptPoints;
    }

    @Override
    public String toString() {
        return "{\"Licenses\":{"
                + "\"getFieldId\":\"" + getFieldId + "\""
                + ", \"getFieldKey\":\"" + getFieldKey + "\""
                + ", \"getFieldLicenseStatusId\":\"" + getFieldLicenseStatusId + "\""
                + ", \"getFieldCreatedAt\":" + getFieldCreatedAt
                + ", \"getFieldUpdatedAt\":" + getFieldUpdatedAt
                + ", \"getFieldKind\":\"" + getFieldKind + "\""
                + ", \"getFieldTitle\":\"" + getFieldTitle + "\""
                + ", \"getFieldProduct\":\"" + getFieldProduct + "\""
                + ", \"getFieldExpiredAt\":" + getFieldExpiredAt
                + ", \"getFieldCaptPoints\":\"" + getFieldCaptPoints + "\""
                + "}}";
    }
}
