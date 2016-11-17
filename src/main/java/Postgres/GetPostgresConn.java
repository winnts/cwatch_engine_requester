package Postgres;

import Postgres.Constants.PostgresProd;
import Postgres.Constants.PostgresStage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by adyachenko on 15.08.16.
 */
public class GetPostgresConn {

    public static String selectConnection = "prod";

    public static Connection connect() {
        String db_addr = null;
        String db_port = null;
        String db_name = null;
        String user = null;
        String pass = null;
        Connection postgresConn = null;
        if (selectConnection == "pre_prod") {
            db_addr = PostgresStage.db_addr;
            db_port = PostgresStage.db_port;
            db_name = PostgresStage.db_name;
            user = PostgresStage.user;
            pass = PostgresStage.pass;
        }
        if (selectConnection == "prod") {
            db_addr = PostgresProd.db_addr;
            db_port = PostgresProd.db_port;
            db_name = PostgresProd.db_name;
            user = PostgresProd.user;
            pass = PostgresProd.pass;
        }

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

    public static void close() throws SQLException {
        GetPostgresConn.connect().close();
    }

}
