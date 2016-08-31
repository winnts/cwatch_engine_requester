package Postgres;

import Postgres.Entity.Applications;

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

    public static List<Applications> collectFields(ResultSet rs) throws SQLException {
        List<Applications> ret = new ArrayList<Applications>();
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
        return ret;
    }

    public static List<Applications> getApplications() throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Applications.TABLE + ";");
        return collectFields(rs);
    }

    public static List<Applications> getApplications(Integer application) throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Applications.TABLE + where + Applications.FIELD_ID + "=\'" + application + "\';");
        return collectFields(rs);
    }

    public static List<Applications> getApplicationsByHost(Integer host_id) throws SQLException {
        ResultSet rs = GetPostgresConn.statement().executeQuery(selectAll + Applications.TABLE + where + Applications.FIELD_HOST_ID + "=\'" + host_id + "\';");
        return collectFields(rs);
    }
}
