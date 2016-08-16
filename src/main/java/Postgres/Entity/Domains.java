package Postgres.Entity;

/**
 * Created by adyachenko on 15.08.16.
 */
public class Domains {
    public static final String TABLE = "domains";
    public static final String FIELD_ID = "id";
    public static final String FIELD_SLUG = "slug";
    public static final String FIELD_OWNER = "owner";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_DOMAIN = "domain";
    public static final String FIELD_DIR = "dir";
    public static final String FIELD_ROOTDOMAIN = "rootdomain";
    public static final String FIELD_HOST_ID = "host_id";
    public static final String FIELD_IS_SUBDOMAIN = "is_subdomain";
    public static final String FIELD_IS_ADDONDOMAIN = "is_addondomain";

    public Integer id;
    public String slug;
    public String owner;
    public String email;
    public String domain;
    public String dir;
    public String rootdomain;
    public Integer host_id;
    public Boolean is_subdomain;
    public Boolean is_addondomain;

    public Domains() {
    }

    public Domains(int id, String domain) {
        this.id = id;
        this.domain = domain;

    }


    @Override
    public String toString() {
        return "{\"Domains\":{"
                + "\"id\":\"" + id + "\""
                + ", \"slug\":\"" + slug + "\""
                + ", \"owner\":\"" + owner + "\""
                + ", \"email\":\"" + email + "\""
                + ", \"domain\":\"" + domain + "\""
                + ", \"dir\":\"" + dir + "\""
                + ", \"rootdomain\":\"" + rootdomain + "\""
                + ", \"host_id\":\"" + host_id + "\""
                + ", \"is_subdomain\":\"" + is_subdomain + "\""
                + ", \"is_addondomain\":\"" + is_addondomain + "\""
                + "}}";
    }
}
