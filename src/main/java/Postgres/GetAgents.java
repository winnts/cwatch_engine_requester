package Postgres;

import Postgres.Entity.Agents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Postgres.Constants.DbConst.selectAll;
import static Postgres.Constants.DbConst.where;

/**
 * Created by adyachenko on 30.08.16.
 */
public class GetAgents {

    public static List<Agents> collectFields(ResultSet rs) throws SQLException {
        List<Agents> ret = new ArrayList<Agents>();
        while (rs.next()) {
            Agents reports = new Agents(
                    rs.getInt(Agents.FIELD_ID),
                    rs.getString(Agents.FIELD_VERSION),
                    rs.getInt(Agents.FIELD_HOST_ID),
                    rs.getTimestamp(Agents.FIELD_CREATED_AT),
                    rs.getTimestamp(Agents.FIELD_UPDATED_AT),
                    rs.getInt(Agents.FIELD_AGENT_STATUS_ID)
            );
            ret.add(reports);
        }
        return ret;
    }

    public static List<Agents> getAgents() throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Agents.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Agents> getAgents(Integer agent) throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Agents.TABLE + where + Agents.FIELD_ID + "=\'" + agent + "\';");
        return collectFields(rs);
    }




}
