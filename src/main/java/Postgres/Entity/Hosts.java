package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 30.08.16.
 */
public class Hosts {
    public static final String TABLE = "hosts";
    public static final String FIELD_ID = "id";
    public static final String FIELD_HOSTNAME = "hostname";
    public static final String FIELD_HASHSUM = "hashsum";
    public static final String FIELD_RESELLER_ID = "reseller_id";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";
    public static final String FIELD_PUBLIC_IP = "public_ip";

    public Integer id;
    public String hostname;
    public String hashsum;
    public Integer reseller_id;
    public Timestamp created_at;
    public Timestamp updated_at;
    public String public_ip;

    public Hosts(Integer id, String hostname, String hashsum, Integer reseller_id, Timestamp created_at, Timestamp updated_at, String public_ip) {
        this.id = id;
        this.hostname = hostname;
        this.hashsum = hashsum;
        this.reseller_id = reseller_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.public_ip = public_ip;
    }

}
