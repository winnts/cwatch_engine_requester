package Postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by adyachenko on 15.08.16.
 */
public class GetPostgresConn {
    public Connection connect (String db_addr, String db_port, String db_name, String user, String pass) {
        Connection postgresConn = null;
        try {
            Class.forName("org.postgresql.Driver");
            postgresConn = DriverManager.getConnection("jdbc:postgresql://"+db_addr+":"+db_port+"/"+db_name,
                    user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return postgresConn;
    }

    public Statement stmt (String db_addr, String db_port, String db_name, String user, String pass) throws SQLException {
        return connect(db_addr, db_port, db_name, user, pass).createStatement();
    }

}
