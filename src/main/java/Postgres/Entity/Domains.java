package Postgres.Entity;

import java.sql.Timestamp;

/**
 * Created by adyachenko on 15.08.16.
 */
public class Domains {
    public static final String TABLE = "domains";
    public static final String FIELD_ID = "id";
    public static final String FIELD_SLUG = "slug";
    public static final String FIELD_OWNER = "owner";
    public static final String FIELD_IPV6 = "ipv6";
    public static final String FIELD_IP = "ip";
    public static final String FIELD_SUSPENDTIME = "suspendtime";
    public static final String FIELD_IS_LOCKED = "is_locked";
    public static final String FIELD_SUSPENDREASON = "suspendreaason";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_DOMAIN = "domain";
    public static final String FIELD_SUSPENDED = "suspended";
    public static final String FIELD_UNIX_STARDATE = "unix_stardate";
    public static final String FIELD_USER = "user";
    public static final String FIELD_PLAN = "plan";
    public static final String FIELD_SHELL = "shell";
    public static final String FIELD_PARTITION = "partition";
    public static final String FIELD_THEME = "theme";
    public static final String FIELD_HOST_ID = "host_id";
    public static final String FIELD_SITE_OWNER_ID = "site_owner_id";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_UPDATED_AT = "updated_at";
    public static final String FIELD_STATUS_ID = "status_id";
    public static final String FIELD_DIR = "dir";
    public static final String FIELD_IS_PARENT = "is_parent";
    public static final String FIELD_ROOTDOMAIN = "rootdomain";
    public static final String FIELD_IS_SUBDOMAIN = "is_subdomain";
    public static final String FIELD_IS_ADDONDOMAIN = "is_addondomain";

    public Integer getFieldId;
    public String getFieldSlug;
    public String getFieldOwner;
    public String getFieldIpv6;
    public String getFieldIp;
    public String getFieldSuspendtime;
    public String getFieldIsLocked;
    public String getFieldSuspendreason;
    public String getFieldEmail;
    public String getFieldDomain;
    public String getFieldSuspended;
    public String getFieldUnixStardate;
    public String getFieldUser;
    public String getFieldPlan;
    public String getFieldShell;
    public String getFieldPartition;
    public String getFieldTheme;
    public Integer getFieldHostId;
    public String getFieldSiteOwnerId;
    public Timestamp getFieldCreatedAt;
    public Timestamp getFieldUpdatedAt;
    public Integer getGetFieldStatusId;
    public String getFieldDir;
    public String getFieldIsParent;
    public String getFieldRootdomain;
    public String getFieldIsSubdomain;
    public String getFieldIsAddondomain;

    public Domains(Integer getFieldId, String getFieldSlug, String getFieldOwner, String getFieldIpv6, String getFieldIp,
                   String getFieldSuspendtime, String getFieldIsLocked, String getFieldSuspendreason, String getFieldEmail,
                   String getFieldDomain, String getFieldSuspended, String getFieldUnixStardate, String getFieldUser,
                   String getFieldPlan, String getFieldShell, String getFieldPartition, String getFieldTheme,
                   Integer getFieldHostId, String getFieldSiteOwnerId, Timestamp getFieldCreatedAt, Timestamp getFieldUpdatedAt,
                   Integer getGetFieldStatusId, String getFieldDir, String getFieldIsParent, String getFieldRootdomain,
                   String getFieldIsSubdomain, String getFieldIsAddondomain) {
        this.getFieldId = getFieldId;
        this.getFieldSlug = getFieldSlug;
        this.getFieldOwner = getFieldOwner;
        this.getFieldIpv6 = getFieldIpv6;
        this.getFieldIp = getFieldIp;
        this.getFieldSuspendtime = getFieldSuspendtime;
        this.getFieldIsLocked = getFieldIsLocked;
        this.getFieldSuspendreason = getFieldSuspendreason;
        this.getFieldEmail = getFieldEmail;
        this.getFieldDomain = getFieldDomain;
        this.getFieldSuspended = getFieldSuspended;
        this.getFieldUnixStardate = getFieldUnixStardate;
        this.getFieldUser = getFieldUser;
        this.getFieldPlan = getFieldPlan;
        this.getFieldShell = getFieldShell;
        this.getFieldPartition = getFieldPartition;
        this.getFieldTheme = getFieldTheme;
        this.getFieldHostId = getFieldHostId;
        this.getFieldSiteOwnerId = getFieldSiteOwnerId;
        this.getFieldCreatedAt = getFieldCreatedAt;
        this.getFieldUpdatedAt = getFieldUpdatedAt;
        this.getGetFieldStatusId = getGetFieldStatusId;
        this.getFieldDir = getFieldDir;
        this.getFieldIsParent = getFieldIsParent;
        this.getFieldRootdomain = getFieldRootdomain;
        this.getFieldIsSubdomain = getFieldIsSubdomain;
        this.getFieldIsAddondomain = getFieldIsAddondomain;
    }

    /*@Override
    public String toString() {
        return "{\"Domains\":{"
                + "\"id\":\"" + getFieldId + "\""
                + ", \"slug\":\"" + getFieldSlug + "\""
                + ", \"owner\":\"" + getFieldOwner + "\""
                + ", \"ipv6\":\"" + getFieldIpv6 + "\""
                + ", \"ip\":\"" + getFieldIp + "\""
                + ", \"suspendtime\":\"" + getFieldSuspendtime + "\""
                + ", \"isLocked\":\"" + getFieldIsLocked + "\""
                + ", \"suspendreason\":\"" + getFieldSuspendreason + "\""
                + ", \"email\":\"" + getFieldEmail + "\""
                + ", \"domain\":\"" + getFieldDomain + "\""
                + ", \"suspended\":\"" + getFieldSuspended + "\""
                + ", \"unixStardate\":\"" + getFieldUnixStardate + "\""
                + ", \"user\":\"" + getFieldUser + "\""
                + ", \"plan\":\"" + getFieldPlan + "\""
                + ", \"shell\":\"" + getFieldShell + "\""
                + ", \"partition\":\"" + getFieldPartition + "\""
                + ", \"theme\":\"" + getFieldTheme + "\""
                + ", \"hostId\":\"" + getFieldHostId + "\""
                + ", \"siteOwnerId\":\"" + getFieldSiteOwnerId + "\""
                + ", \"createdAt\":\"" + getFieldCreatedAt + "\""
                + ", \"updatedAt\":\"" + getFieldUpdatedAt + "\""
                + ", \"statusId\":\"" + getGetFieldStatusId + "\""
                + ", \"dir\":\"" + getFieldDir + "\""
                + ", \"parent\":\"" + getFieldIsParent + "\""
                + ", \"rootdomain\":\"" + getFieldRootdomain + "\""
                + ", \"isSubdomain\":\"" + getFieldIsSubdomain + "\""
                + ", \"isAddondomain\":\"" + getFieldIsAddondomain + "\""
                + "}}";
    }*/
    @Override
    public String toString() {
        return "{"
                + "\"id\":\"" + getFieldId + "\""
                + ", \"slug\":\"" + getFieldSlug + "\""
                + ", \"owner\":\"" + getFieldOwner + "\""
                + ", \"ipv6\":\"" + getFieldIpv6 + "\""
                + ", \"ip\":\"" + getFieldIp + "\""
                + ", \"suspendtime\":\"" + getFieldSuspendtime + "\""
                + ", \"isLocked\":\"" + getFieldIsLocked + "\""
                + ", \"suspendreason\":\"" + getFieldSuspendreason + "\""
                + ", \"email\":\"" + getFieldEmail + "\""
                + ", \"domain\":\"" + getFieldDomain + "\""
                + ", \"suspended\":\"" + getFieldSuspended + "\""
                + ", \"unixStardate\":\"" + getFieldUnixStardate + "\""
                + ", \"user\":\"" + getFieldUser + "\""
                + ", \"plan\":\"" + getFieldPlan + "\""
                + ", \"shell\":\"" + getFieldShell + "\""
                + ", \"partition\":\"" + getFieldPartition + "\""
                + ", \"theme\":\"" + getFieldTheme + "\""
                + ", \"hostId\":\"" + getFieldHostId + "\""
                + ", \"siteOwnerId\":\"" + getFieldSiteOwnerId + "\""
                + ", \"createdAt\":\"" + getFieldCreatedAt + "\""
                + ", \"updatedAt\":\"" + getFieldUpdatedAt + "\""
                + ", \"statusId\":\"" + getGetFieldStatusId + "\""
                + ", \"dir\":\"" + getFieldDir + "\""
                + ", \"parent\":\"" + getFieldIsParent + "\""
                + ", \"rootdomain\":\"" + getFieldRootdomain + "\""
                + ", \"isSubdomain\":\"" + getFieldIsSubdomain + "\""
                + ", \"isAddondomain\":\"" + getFieldIsAddondomain + "\""
                + "}";
    }
}
