package Postgres;

import Postgres.Entity.Agents;
import Postgres.Entity.AgentsHosts;
import Postgres.Entity.Hosts;
import Postgres.Entity.SystemInformations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.*;

/**
 * Created by adyachenko on 30.08.16.
 */
public class GetAgentsHosts {
    public static List<AgentsHosts> collectFields(String sql) throws SQLException {
        List<AgentsHosts> ret = new ArrayList<AgentsHosts>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AgentsHosts reports = new AgentsHosts(
                            rs.getInt(AgentsHosts.FIELD_ID),
                            rs.getString(AgentsHosts.FIELD_HOSTNAME),
                            rs.getString(AgentsHosts.FIELD_VERSION),
                            rs.getString(SystemInformations.FIELD_PUBLIC_IP),
                            rs.getTimestamp(AgentsHosts.FIELD_UPDATED_AT),
                            rs.getInt(AgentsHosts.FIELD_HOST_ID)
                    );
                    ret.add(reports);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static List<AgentsHosts> getAgentsHosts() throws SQLException {
        String sql = select + Agents.TABLE+"."+Agents.FIELD_ID + ", "
                + Hosts.TABLE+"."+Hosts.FIELD_HOSTNAME + ", " + Agents.TABLE+"."+Agents.FIELD_VERSION + ", "
                + SystemInformations.TABLE+"."+SystemInformations.FIELD_PUBLIC_IP + ", "
                + SystemInformations.TABLE+"."+SystemInformations.FIELD_UPDATED_AT + ", "
                + Agents.TABLE+"."+Agents.FIELD_HOST_ID
                + from + Agents.TABLE
                + innerJoin + Hosts.TABLE + on + Agents.TABLE + "." + Agents.FIELD_HOST_ID + "=" + Hosts.TABLE+"."+Hosts.FIELD_ID
                + innerJoin + SystemInformations.TABLE + on + SystemInformations.TABLE + "." + SystemInformations.FIELD_HOST_ID + "=" + Hosts.TABLE+"."+Hosts.FIELD_ID
                + " ORDER BY " + Agents.TABLE+"."+Agents.FIELD_ID +";";
        return collectFields(sql);
    }

}
