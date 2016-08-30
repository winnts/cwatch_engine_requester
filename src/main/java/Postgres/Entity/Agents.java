package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 30.08.16.
 */
public class Agents {
    public static final String TABLE = "agents";
    public static final String FIELD_ID = "id";
    public static final String FIELD_VERSION = "version";
    public static final String FIELD_HOST_ID = "host_id";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";
    public static final String FIELD_AGENT_STATUS_ID = "agent_status_id";

    public Integer id;
    public String version;
    public Integer host_id;
    public Timestamp created_at;
    public Timestamp updated_at;
    public Integer agent_status_id;

    public Agents(Integer id, String version, Integer host_id, Timestamp created_at, Timestamp updated_at, Integer agent_status_id) {
        this.id = id;
        this.version = version;
        this.host_id = host_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.agent_status_id = agent_status_id;
    }
}
