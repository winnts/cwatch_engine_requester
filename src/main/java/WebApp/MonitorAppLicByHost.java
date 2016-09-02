package WebApp;

import Postgres.Reports.LicensesAndDomains;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import static Postgres.GetLicensesPermits.requestLicensesPerDomainAndHost;

/**
 * Created by adyachenko on 29.08.16.
 */
@Path("/lbh")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorAppLicByHost {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MonitorAppLicByHost(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SendLicByHost sendData(@QueryParam("host_id") Integer host_id) throws SQLException {
        return new SendLicByHost(counter.incrementAndGet(), LicensesAndDomains.getLicensesAll(requestLicensesPerDomainAndHost(host_id)));
    }

}
