package Postgres.Entity;

/**
 * Created by adyachenko on 16.11.16.
 */
public class WafControlDomains {
    public static final String FIELD_ID = "id";
    public static final String FIELD_IP = "ip";
    public static final String FIELD_DOMAIN_ID = "domain_id";
    public static final String FIELD_WAF_CONTROL_ID = "waf_control_id";
    public static final String FIELD_TOKEN = "token";
    public static final String FIELD_TYPE = "type";

    public Integer id;
    public String ip;
    public Integer domain_id;
    public Integer waf_control_id;
    public String type;
    public String token;

    public WafControlDomains(Integer id, String ip, Integer domain_id, Integer waf_control_id, String type, String token) {
        this.id = id;
        this.ip = ip;
        this.domain_id = domain_id;
        this.waf_control_id = waf_control_id;
        this.type = type;
        this.token = token;
    }
}
