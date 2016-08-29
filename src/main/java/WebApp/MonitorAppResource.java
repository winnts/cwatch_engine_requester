package WebApp;

import Postgres.GetDomains;
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
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorAppResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MonitorAppResource(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SendData sendHello(@QueryParam("name") Optional<String> name) throws SQLException {
//        final String value = String.format(template, name.orElse(defaultName));
        final String value = String.format(template, GetDomains.getAllDomains());
        return new SendData(counter.incrementAndGet(), value);
    }

}
