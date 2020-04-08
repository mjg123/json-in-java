
package lol.gilliard.jsonparse.databinding.complex.gson.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class NeoWsDataGson {

    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("element_count")
    @Expose
    public long elementCount;
    @SerializedName("near_earth_objects")
    @Expose
    public Map<String, List<NeoDetails>> nearEarthObjects;

}
