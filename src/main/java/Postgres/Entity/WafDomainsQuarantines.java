package Postgres.Entity;

import java.util.Date;

/**
 * Created by adyachenko on 16.11.16.
 */
public class WafDomainsQuarantines {
    public static final String TABLE = "waf_domain_quarantines";
    public static final String FIELD_ID = "id";
    public static final String FIELD_DOMAIN_ID = "domain_id";
    public static final String FIELD_WAF_CONTROL_ID = "waf_control_id";
    public static final String FIELD_TOKEN = "token";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";

    public Integer id;
    public Integer domain_id;
    public Integer waf_control_id;
    public String token;
    public Date created_at;
    public Date updated_at;

    public WafDomainsQuarantines(Integer id, Integer domain_id, Integer waf_control_id, String token, Date created_at, Date updated_at) {
        this.id = id;
        this.domain_id = domain_id;
        this.waf_control_id = waf_control_id;
        this.token = token;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
