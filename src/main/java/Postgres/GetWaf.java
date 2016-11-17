package Postgres;

import Postgres.Entity.WafControlDomains;
import Postgres.Entity.WafControls;
import Postgres.Entity.WafDomainsQuarantines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Postgres.Constants.DbConst.*;
/**
 * Created by adyachenko on 16.11.16.
 */
public class GetWaf {
    public static List<WafControlDomains> collectFields(String sql)throws SQLException{
        List<WafControlDomains> ret = new ArrayList<>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    WafControlDomains wafControlDomains = new WafControlDomains(
                            rs.getInt(WafControlDomains.FIELD_ID),
                            rs.getString(WafControlDomains.FIELD_IP),
                            rs.getInt(WafControlDomains.FIELD_DOMAIN_ID),
                            rs.getInt(WafControlDomains.FIELD_WAF_CONTROL_ID),
                            rs.getString(WafControlDomains.FIELD_TYPE),
                            rs.getString(WafControlDomains.FIELD_TOKEN)
                    );
                    ret.add(wafControlDomains);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
    public static List<WafControlDomains> getWhiteListByDomain (String domain) throws SQLException{
        Integer id = GetDomains.getDomainIdByName(domain);
        String sql = select + WafControls.TABLE+"."+WafControls.FIELD_ID+","
                            + WafControls.TABLE+"."+WafControls.FIELD_IP+","
                            + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_DOMAIN_ID+","
                            + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_WAF_CONTROL_ID+","
                            + WafControls.TABLE+"."+WafControls.FIELD_TYPE+","
                            + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_TOKEN
                            + from + WafDomainsQuarantines.TABLE
                            + innerJoin + WafControls.TABLE + on
                            + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_WAF_CONTROL_ID+"="+WafControls.TABLE+"."+WafControls.FIELD_ID
                            + where + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_DOMAIN_ID+"="+id
                            + and + WafControls.TABLE+"."+WafControls.FIELD_TYPE+"="+"\'Waf::Whitelist\'"+";";
        return collectFields(sql);
    }
    public static List<WafControlDomains> getBlackListByDomain (String domain) throws SQLException{
        Integer id = GetDomains.getDomainIdByName(domain);
        String sql = select + WafControls.TABLE+"."+WafControls.FIELD_ID+","
                + WafControls.TABLE+"."+WafControls.FIELD_IP+","
                + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_DOMAIN_ID+","
                + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_WAF_CONTROL_ID+","
                + WafControls.TABLE+"."+WafControls.FIELD_TYPE+","
                + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_TOKEN
                + from + WafDomainsQuarantines.TABLE
                + innerJoin + WafControls.TABLE + on
                + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_WAF_CONTROL_ID+"="+WafControls.TABLE+"."+WafControls.FIELD_ID
                + where + WafDomainsQuarantines.TABLE+"."+WafDomainsQuarantines.FIELD_DOMAIN_ID+"="+id
                + and + WafControls.TABLE+"."+WafControls.FIELD_TYPE+"="+"\'Waf::Blacklist\'"+";";
        return collectFields(sql);
    }
}
