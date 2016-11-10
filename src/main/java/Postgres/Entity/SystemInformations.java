package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 10.11.16.
 */
public class SystemInformations {
    public static final String TABLE = "system_informations";
    public static final String FIELD_ID = "id";
    public static final String FIELD_HOST_ID = "host_id";
    public static final String FIELD_OS = "os";
    public static final String FIELD_OS_VERSION = "os_version";
    public static final String FIELD_ARCHNAME = "archname";
    public static final String FIELD_TOTALMEM = "totalmem";
    public static final String FIELD_FREEMEM = "freemem";
    public static final String FIELD_USEDMEM = "usedmem";
    public static final String FIELD_USED_PERCENT = "used_percent";
    public static final String FIELD_CPU_USAGE = "cpu_usage";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";
    public static final String FIELD_PUBLIC_IP = "public_ip";

    public Integer id;
    public Integer host_id;
    public String os;
    public String os_version;
    public String archname;
    public String totalmem;
    public String freemem;
    public String usedmem;
    public String used_percent;
    public String cpu_usage;
    public Timestamp created_at;
    public Timestamp updated_at;
    public String public_ip;

    public SystemInformations(Integer id, Integer host_id, String os, String os_version, String archname, String totalmem, String freemem, String usedmem, String used_percent, String cpu_usage, Timestamp created_at, Timestamp updated_at, String public_ip) {
        this.id = id;
        this.host_id = host_id;
        this.os = os;
        this.os_version = os_version;
        this.archname = archname;
        this.totalmem = totalmem;
        this.freemem = freemem;
        this.usedmem = usedmem;
        this.used_percent = used_percent;
        this.cpu_usage = cpu_usage;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.public_ip = public_ip;
    }
}
