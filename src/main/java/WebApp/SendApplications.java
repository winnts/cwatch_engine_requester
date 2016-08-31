package WebApp;

import Postgres.Entity.Applications;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SendApplications {
    private long id;

    private List<Applications> content;

    public SendApplications(long id, List<Applications> content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<Applications> getContent() {
        return content;
    }


}
