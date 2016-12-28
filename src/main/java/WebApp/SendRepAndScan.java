package WebApp;

import Entity.RepAndScanStats;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by adyachenko on 16.11.16.
 */
public class SendRepAndScan {
    private long id;
    private List<RepAndScanStats> content;

    public SendRepAndScan (long id, List<RepAndScanStats> content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }
    @JsonProperty
    public List<RepAndScanStats> getContent() {
        return content;
    }
}
