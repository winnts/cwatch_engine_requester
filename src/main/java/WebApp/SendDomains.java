package WebApp;

import Entity.Domains;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SendDomains {
    private long id;

    private List<Domains> content;

    public SendDomains(long id, List<Domains> content){
        this.id = id;
        this.content = content;
    }


    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<Domains> getContent() {
        return content;
    }


}
