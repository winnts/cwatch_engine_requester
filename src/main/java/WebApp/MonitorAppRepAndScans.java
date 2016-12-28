package WebApp;

import Gets.GetRepAndScanStats;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by adyachenko on 16.11.16.
 */
@Path("/repandscans")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorAppRepAndScans {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MonitorAppRepAndScans(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }
    @GET
    @Timed
    public SendRepAndScan sendData(@QueryParam("domain") String domain) throws SQLException {
        return new SendRepAndScan(counter.incrementAndGet(), GetRepAndScanStats.getRepAndScanStats(domain));
    }
}
