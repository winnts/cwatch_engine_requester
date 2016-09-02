package Postgres;

import Postgres.Entity.Hosts;

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
public class GetHosts {
    public static List<Hosts> collectFields(String sql) throws SQLException {
        List<Hosts> ret = new ArrayList<Hosts>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hosts reports = new Hosts(
                            rs.getInt(Hosts.FIELD_ID),
                            rs.getString(Hosts.FIELD_HOSTNAME),
                            rs.getString(Hosts.FIELD_HASHSUM),
                            rs.getInt(Hosts.FIELD_RESELLER_ID),
                            rs.getTimestamp(Hosts.FIELD_CREATED_AT),
                            rs.getTimestamp(Hosts.FIELD_UPDATED_AT),
                            rs.getString(Hosts.FIELD_PUBLIC_IP)
                    );
                    ret.add(reports);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    public static List<Hosts> getHosts() throws SQLException {
        String sql = selectAll + Hosts.TABLE + ";";
        return collectFields(sql);
    }

    public static List<Hosts> getHosts(String hostname) throws SQLException {
        String sql = selectAll + Hosts.TABLE + where + Hosts.FIELD_HOSTNAME + "=\'" + hostname + "\';";
        return collectFields(sql);
    }
}
