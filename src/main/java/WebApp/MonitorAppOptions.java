package WebApp;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by adyachenko on 29.08.16.
 */
@Path("/options")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorAppOptions {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MonitorAppOptions(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @POST
    @Timed
    public void switchEnv(@QueryParam("env") String env) throws IOException, SQLException {
        System.out.println("Get from UI: " + env);
//        GetPostgresConn.close();
//        GetPostgresConn.selectConnection = env;
//        System.out.println(GetPostgresConn.selectConnection);
    }
}
