package WebApp;

import Entity.WafControlDomains;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by adyachenko on 16.11.16.
 */
public class SendWaf {
    private long id;
    private List<WafControlDomains> content;

    public SendWaf(long id, List<WafControlDomains> content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }
    @JsonProperty
    public List<WafControlDomains> getContent() {
        return content;
    }
}
