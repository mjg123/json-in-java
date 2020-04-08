
package lol.gilliard.jsonparse.databinding.complex.jackson.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "close_approach_date",
    "close_approach_date_full",
    "epoch_date_close_approach",
    "relative_velocity",
    "miss_distance",
    "orbiting_body"
})
public class CloseApproachDatum {

    @JsonProperty("close_approach_date")
    public LocalDate closeApproachDate;
    @JsonProperty("close_approach_date_full")
    public String closeApproachDateFull;
    @JsonProperty("epoch_date_close_approach")
    public long epochDateCloseApproach;
    @JsonProperty("relative_velocity")
    public RelativeVelocity relativeVelocity;
    @JsonProperty("miss_distance")
    public MissDistance missDistance;
    @JsonProperty("orbiting_body")
    public String orbitingBody;

}
