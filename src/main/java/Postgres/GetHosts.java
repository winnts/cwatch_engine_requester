package Postgres;

import Postgres.Entity.Hosts;

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
    public static List<Hosts> collectFields(ResultSet rs) throws SQLException {
        List<Hosts> ret = new ArrayList<Hosts>();
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
        return ret;
    }

    public static List<Hosts> getHosts() throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Hosts.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Hosts> getHosts(String hostname) throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Hosts.TABLE + where + Hosts.FIELD_HOSTNAME + "=\'" + hostname + "\';");
        return collectFields(rs);
    }
}
