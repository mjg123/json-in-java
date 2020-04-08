
package lol.gilliard.jsonparse.databinding.complex.gson.generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstimatedDiameter {

    @SerializedName("kilometers")
    @Expose
    public Kilometers kilometers;
    @SerializedName("meters")
    @Expose
    public Meters meters;
    @SerializedName("miles")
    @Expose
    public Miles miles;
    @SerializedName("feet")
    @Expose
    public Feet feet;

}
