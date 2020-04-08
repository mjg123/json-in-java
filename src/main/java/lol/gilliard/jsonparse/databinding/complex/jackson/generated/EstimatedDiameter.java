
package lol.gilliard.jsonparse.databinding.complex.jackson.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kilometers",
    "meters",
    "miles",
    "feet"
})
public class EstimatedDiameter {

    @JsonProperty("kilometers")
    public Kilometers kilometers;
    @JsonProperty("meters")
    public Meters meters;
    @JsonProperty("miles")
    public Miles miles;
    @JsonProperty("feet")
    public Feet feet;

}
