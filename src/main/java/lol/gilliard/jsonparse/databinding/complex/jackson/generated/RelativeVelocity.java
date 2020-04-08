
package lol.gilliard.jsonparse.databinding.complex.jackson.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kilometers_per_second",
    "kilometers_per_hour",
    "miles_per_hour"
})
public class RelativeVelocity {

    @JsonProperty("kilometers_per_second")
    public double kilometersPerSecond;
    @JsonProperty("kilometers_per_hour")
    public double kilometersPerHour;
    @JsonProperty("miles_per_hour")
    public double milesPerHour;

}
