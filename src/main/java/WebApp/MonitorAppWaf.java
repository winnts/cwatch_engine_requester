package WebApp;

import Gets.GetWaf;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by adyachenko on 29.08.16.
 */
@Path("/waf")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorAppWaf {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MonitorAppWaf(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @Path("whitelist")
    @GET
    @Timed
    public SendWaf sendWhiteList(@QueryParam("domain") String domain) throws SQLException {
        return new SendWaf(counter.incrementAndGet(), GetWaf.getWhiteListByDomain(domain));
    }

    @Path("blacklist")
    @GET
    @Timed
    public SendWaf sendBlackList(@QueryParam("domain") String domain) throws SQLException {
        return new SendWaf(counter.incrementAndGet(), GetWaf.getBlackListByDomain(domain));
    }
}
