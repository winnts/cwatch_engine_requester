package Postgres;

import Postgres.Constants.PostgresProd;
import Postgres.Constants.PostgresStage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by adyachenko on 15.08.16.
 */
public class GetPostgresConn {

    public static Connection connect(String db_addr, String db_port, String db_name, String user, String pass) {
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

//    public Statement stmt() throws SQLException {
//        return connect().createStatement();
//    }

    public static Connection connectToProd () {
        return connect(PostgresProd.db_addr, PostgresProd.db_port, PostgresProd.db_name, PostgresProd.user, PostgresProd.pass);
    }
    public static Connection connectToStage () {
        return connect(PostgresStage.db_addr, PostgresStage.db_port, PostgresStage.db_name, PostgresStage.user, PostgresStage.pass);
    }

    public static Statement statement() throws SQLException {
        Statement statement = connectToStage().createStatement();
        return statement;
    }

}
