package Postgres;

import Postgres.Entity.Applications;

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
public class GetApplications {

    public static List<Applications> collectFields(String sql) throws SQLException {
        List<Applications> ret = new ArrayList<Applications>();
        try (Connection conn = GetPostgresConn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Applications reports = new Applications(
                            rs.getInt(Applications.FIELD_ID),
                            rs.getString(Applications.FIELD_NAME),
                            rs.getString(Applications.FIELD_VERSION),
                            rs.getString(Applications.FIELD_PATH),
                            rs.getBoolean(Applications.FIELD_RUNNING),
                            rs.getInt(Applications.FIELD_HOST_ID),
                            rs.getTimestamp(Applications.FIELD_CREATED_AT),
                            rs.getTimestamp(Applications.FIELD_UPDATED_AT)
                    );
                    ret.add(reports);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static List<Applications> getApplications() throws SQLException {
        String sql = selectAll + Applications.TABLE + ";";
        return collectFields(sql);
    }

    public static List<Applications> getApplications(Integer application) throws SQLException {
        String sql = selectAll + Applications.TABLE + where + Applications.FIELD_ID + "=\'" + application + "\';";
        return collectFields(sql);
    }

    public static List<Applications> getApplicationsByHost(Integer host_id) throws SQLException {
        String sql = selectAll + Applications.TABLE + where + Applications.FIELD_HOST_ID + "=\'" + host_id + "\';";
        return collectFields(sql);
    }
}
