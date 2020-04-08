
package lol.gilliard.jsonparse.databinding.complex.jackson.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "next",
    "prev",
    "self"
})
public class Links {

    @JsonProperty("next")
    public String next;
    @JsonProperty("prev")
    public String prev;
    @JsonProperty("self")
    public String self;

}
