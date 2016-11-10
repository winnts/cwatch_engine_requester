package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 30.08.16.
 */
public class AgentsHosts {

    public static final String FIELD_ID = "id";
    public static final String FIELD_HOSTNAME = "hostname";
    public static final String FIELD_VERSION = "version";
    public static final String FIELD_PUBLIC_IP = "public_ip";
    public static final String FIELD_UPDATED_AT = "updated_at";
    public static final String FIELD_HOST_ID = "host_id";

    public Integer id;
    public String hostname;
    public String version;
    public String public_ip;
    public Timestamp updated_at;
    public Integer host_id;

    public AgentsHosts(Integer id, String hostname, String version, String public_ip, Timestamp updated_at, Integer host_id) {
        this.id = id;
        this.hostname = hostname;
        this.version = version;
        this.public_ip = public_ip;
        this.updated_at = updated_at;
        this.host_id = host_id;
    }
}
