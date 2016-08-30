package Postgres;

import Postgres.Entity.Agents;
import Postgres.Entity.AgentsHosts;
import Postgres.Entity.Hosts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.innerJoin;
import static Postgres.Constants.DbConst.select;

/**
 * Created by adyachenko on 30.08.16.
 */
public class GetAgentsHosts {
    public static List<AgentsHosts> collectFields(ResultSet rs) throws SQLException {
        List<AgentsHosts> ret = new ArrayList<AgentsHosts>();
        while (rs.next()) {
            AgentsHosts reports = new AgentsHosts(
                    rs.getInt(AgentsHosts.FIELD_ID),
                    rs.getString(AgentsHosts.FIELD_HOSTNAME),
                    rs.getString(AgentsHosts.FIELD_VERSION),
                    rs.getString(AgentsHosts.FIELD_PUBLIC_IP),
                    rs.getTimestamp(AgentsHosts.FIELD_UPDATED_AT),
                    rs.getInt(AgentsHosts.FIELD_HOST_ID)
            );
            ret.add(reports);
        }
        return ret;
    }

    public static List<AgentsHosts> getAgentsHosts() throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(select + Agents.TABLE+"."+Agents.FIELD_ID + ", "
                + Hosts.TABLE+"."+Hosts.FIELD_HOSTNAME + ", " + Agents.TABLE+"."+Agents.FIELD_VERSION + ", "
                + Hosts.TABLE+"."+Hosts.FIELD_PUBLIC_IP + ", "
                + Agents.TABLE+"."+Agents.FIELD_UPDATED_AT + ", "
                + Agents.TABLE+"."+Agents.FIELD_HOST_ID
                + " FROM " + Agents.TABLE + innerJoin + Hosts.TABLE
                + " ON " + Agents.TABLE + "." + Agents.FIELD_HOST_ID + "=" + Hosts.TABLE+"."+Hosts.FIELD_ID
                + ";");
        return collectFields(rs);
    }

}
