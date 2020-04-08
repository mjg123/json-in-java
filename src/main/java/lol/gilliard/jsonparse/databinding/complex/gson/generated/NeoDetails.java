
package lol.gilliard.jsonparse.databinding.complex.gson.generated;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NeoDetails {

    @SerializedName("links")
    @Expose
    public Links_ links;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("neo_reference_id")
    @Expose
    public String neoReferenceId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("nasa_jpl_url")
    @Expose
    public String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    @Expose
    public double absoluteMagnitudeH;
    @SerializedName("estimated_diameter")
    @Expose
    public EstimatedDiameter estimatedDiameter;
    @SerializedName("is_potentially_hazardous_asteroid")
    @Expose
    public boolean isPotentiallyHazardousAsteroid;
    @SerializedName("close_approach_data")
    @Expose
    public List<CloseApproachDatum> closeApproachData = null;
    @SerializedName("is_sentry_object")
    @Expose
    public boolean isSentryObject;

}
