
package lol.gilliard.jsonparse.databinding.complex.gson.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloseApproachDatum {

    @SerializedName("close_approach_date")
    @Expose
    public String closeApproachDate;
    @SerializedName("close_approach_date_full")
    @Expose
    public String closeApproachDateFull;
    @SerializedName("epoch_date_close_approach")
    @Expose
    public long epochDateCloseApproach;
    @SerializedName("relative_velocity")
    @Expose
    public RelativeVelocity relativeVelocity;
    @SerializedName("miss_distance")
    @Expose
    public MissDistance missDistance;
    @SerializedName("orbiting_body")
    @Expose
    public String orbitingBody;

}
