
package lol.gilliard.jsonparse.databinding.complex.jackson.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "estimated_diameter_min",
    "estimated_diameter_max"
})
public class Miles {

    @JsonProperty("estimated_diameter_min")
    public double estimatedDiameterMin;
    @JsonProperty("estimated_diameter_max")
    public double estimatedDiameterMax;

}
