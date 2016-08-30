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
@Path("/domains")
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
    public SendData sendData(@QueryParam("name") Optional<String> name) throws SQLException {
        if (!name.isPresent()) {
            return new SendData(counter.incrementAndGet(), GetDomains.getDomain());
        } else {
            return new SendData(counter.incrementAndGet(), GetDomains.getDomain(name.orElse("")));}
    }
}
