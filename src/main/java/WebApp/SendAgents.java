package WebApp;

import Postgres.Entity.AgentsHosts;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SendAgents {
    private long id;

    private List<AgentsHosts> content;

    public SendAgents(long id, List<AgentsHosts> content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<AgentsHosts> getContent() {
        return content;
    }


}
