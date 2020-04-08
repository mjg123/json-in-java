
package lol.gilliard.jsonparse.databinding.complex.jackson.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "astronomical",
    "lunar",
    "kilometers",
    "miles"
})
public class MissDistance {

    @JsonProperty("astronomical")
    public double astronomical;
    @JsonProperty("lunar")
    public double lunar;
    @JsonProperty("kilometers")
    public double kilometers;
    @JsonProperty("miles")
    public double miles;

}
