package Postgres;

import Postgres.Entity.LicensesPermits;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 17.08.16.
 */
public class GetLicensesPermits {
    public static List<LicensesPermits> collectFields(ResultSet rs) throws SQLException {
        List<LicensesPermits> ret = new ArrayList<LicensesPermits>();
        while (rs.next()) {
            LicensesPermits reports = new LicensesPermits(
                    rs.getInt(LicensesPermits.FIELD_ID),
                    rs.getInt(LicensesPermits.FIELD_LICENSE_ID),
                    rs.getInt(LicensesPermits.FIELD_CLIENTABLE_ID),
                    rs.getString(LicensesPermits.FIELD_CLIENTABLE_TYPE),
                    rs.getTimestamp(LicensesPermits.FIELD_CREATED_AT),
                    rs.getTimestamp(LicensesPermits.FIELD_UPDATED_AT)
            );
            ret.add(reports);
        }
        return ret;
    }
}
