package Postgres;

import Postgres.Entity.Domains;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 15.08.16.
 */
public class SelectFromDB {
    public static List<Domains> getAllDomains(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Domains.TABLE + ";");
        List<Domains> ret = new ArrayList<Domains>();
        try {
            while (rs.next()) {
                Domains domains = new Domains(
                        rs.getInt(Domains.FIELD_ID),
                        rs.getString(Domains.FIELD_DOMAIN)
                        );
                ret.add(domains);
            }

        } catch (SQLException e) {
        }
        return ret;

    }

    public static List<Domains> getByDomains(Statement statement, String domain) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM " + Domains.TABLE + " WHERE " + Domains.FIELD_DOMAIN + "=\'" + domain + "\';");
        List<Domains> ret = new ArrayList<Domains>();
        try {
            while (rs.next()) {
                Domains domains = new Domains(
                        rs.getInt(Domains.FIELD_ID),
                        rs.getString(Domains.FIELD_DOMAIN)
                );
                ret.add(domains);
            }

        } catch (SQLException e) {
        }
        return ret;

    }

    public static void main(String[] args) throws SQLException {
        GetPostgresConn conn = new GetPostgresConn();
        Statement statement = conn.stmt();
//        System.out.println(getAllDomains(statement));
        System.out.println(getByDomains(statement, "acmeroborent.com"));
        statement.close();


    }
}
