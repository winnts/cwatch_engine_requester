package Postgres.Entity;

import java.util.Date;

/**
 * Created by adyachenko on 16.11.16.
 */
public class WafControls {
    public static final String TABLE = "waf_controls";
    public static final String FIELD_ID = "id";
    public static final String FIELD_IP = "ip";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_TOKEN = "token";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";

    public Integer id;
    public String ip;
    public String type;
    public String token;
    public Date created_at;
    public Date updated_at;
}
