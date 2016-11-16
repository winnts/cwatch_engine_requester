package Postgres;

import Postgres.Entity.WafControlDomains;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "";
        return collectFields(sql);
    }

}
