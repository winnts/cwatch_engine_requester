package Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by adyachenko on 15.08.16.
 */
public class GetPostgresConn {
    public Connection connect () {
        Connection postgresConn = null;
        try {
            Class.forName("org.postgresql.Driver");
            postgresConn = DriverManager.getConnection("jdbc:postgresql://10.8.3.90:5432/cwatch_production",
                    "pguser", "password");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return postgresConn;
    }

    public Statement stmt () throws SQLException {
        return connect().createStatement();
    }

}
