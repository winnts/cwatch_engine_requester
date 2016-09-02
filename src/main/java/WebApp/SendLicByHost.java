package WebApp;

import Postgres.Entity.LicensesByHost;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SendLicByHost {
    private long id;

    private List<LicensesByHost> content;

    public SendLicByHost(long id, List<LicensesByHost> content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<LicensesByHost> getContent() {
        return content;
    }


}
