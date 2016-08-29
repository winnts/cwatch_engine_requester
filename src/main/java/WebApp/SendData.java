package WebApp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SendData {
    private long id;

    private String content;

    public SendData(long id, String content){
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
