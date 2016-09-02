package Postgres;

import Postgres.Entity.Agents;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static List<Agents> collectFields(String sql) throws SQLException {
        List<Agents> ret = new ArrayList<Agents>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static List<Agents> getAgents() throws SQLException {
        String sql = selectAll + Agents.TABLE + ";";
        return collectFields(sql);
    }

    public static List<Agents> getAgents(Integer agent) throws SQLException {
        String sql = selectAll + Agents.TABLE + where + Agents.FIELD_ID + "=\'" + agent + "\';";
        return collectFields(sql);
    }




}
