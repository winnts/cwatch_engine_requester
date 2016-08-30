package WebApp;

import Postgres.GetAgentsHosts;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by adyachenko on 29.08.16.
 */
@Path("/agents")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorAppAgents {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MonitorAppAgents(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SendAgents sendData(@QueryParam("id") Optional<Integer> id) throws SQLException {
          return new SendAgents(counter.incrementAndGet(), GetAgentsHosts.getAgentsHosts());
    }
}
