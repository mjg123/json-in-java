package lol.gilliard.jsonparse.treemodels;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lol.gilliard.jsonparse.SourceData;

import java.util.Map;

public class GsonTreeModel {

    // JsonParser is stateless and thread-safe so it's OK to create one like this
    private static final JsonParser parser = new JsonParser();

    public static void main(String[] args) {

        JsonElement neoJsonElement = parser.parse(SourceData.asString());

        System.out.println("NEO count: " + getNeoCount(neoJsonElement));

        System.out.println("Potentially hazardous asteroids: " +
            getPotentiallyHazardousAsteroidCount(neoJsonElement));

        NeoNameAndSpeed fastestNEO = getFastestNEO(neoJsonElement);
        System.out.println(
            String.format("Fastest NEO is: %s at %f km/sec",
                fastestNEO.name, fastestNEO.speed));

    }

    private static int getNeoCount(JsonElement neoJsonElement) {
        return neoJsonElement
            .getAsJsonObject()
            .get("element_count")
            .getAsInt();
    }

    private static int getPotentiallyHazardousAsteroidCount(JsonElement neoJsonElement) {
        int potentiallyHazardousAsteroidCount = 0;
        JsonElement nearEarthObjects = neoJsonElement.getAsJsonObject().get("near_earth_objects");
        for (Map.Entry<String, JsonElement> neoClosestApproachDate : nearEarthObjects.getAsJsonObject().entrySet()) {
            for (JsonElement neo : neoClosestApproachDate.getValue().getAsJsonArray()) {
                if (neo.getAsJsonObject().get("is_potentially_hazardous_asteroid").getAsBoolean()) {
                    potentiallyHazardousAsteroidCount += 1;
                }
            }
        }
        return potentiallyHazardousAsteroidCount;
    }

        private static NeoNameAndSpeed getFastestNEO(JsonElement neoJsonElement) {
        NeoNameAndSpeed fastestNEO = null;
        JsonElement nearEarthObjects = neoJsonElement.getAsJsonObject().get("near_earth_objects");
        for (Map.Entry<String, JsonElement> neoClosestApproachDate : nearEarthObjects.getAsJsonObject().entrySet()) {
            for (JsonElement neo : neoClosestApproachDate.getValue().getAsJsonArray()) {
                double speed = neo.getAsJsonObject()
                    .get("close_approach_data").getAsJsonArray()
                    .get(0).getAsJsonObject()
                    .get("relative_velocity").getAsJsonObject()
                    .get("kilometers_per_second")
                    .getAsDouble();

                if ( fastestNEO == null ||  speed > fastestNEO.speed ){
                    fastestNEO = new NeoNameAndSpeed(neo.getAsJsonObject().get("name").getAsString(), speed);
                }
            }
        }
        return fastestNEO;
    }

}
