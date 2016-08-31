package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 31.08.16.
 */
public class Applications {
    public static final String TABLE = "applications";
    public static final String FIELD_ID="id";
    public static final String FIELD_NAME="name";
    public static final String FIELD_VERSION="version";
    public static final String FIELD_PATH="path";
    public static final String FIELD_RUNNING="running";
    public static final String FIELD_HOST_ID="host_id";
    public static final String FIELD_CREATED_AT="created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";


    public Integer id;
    public String name;
    public String version;
    public String path;
    public Boolean running;
    public Integer host_id;
    public Timestamp created_at;
    public Timestamp updated_at;

    public Applications(Integer id, String name, String version, String path, Boolean running, Integer host_id, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.path = path;
        this.running = running;
        this.host_id = host_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
