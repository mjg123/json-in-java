package lol.gilliard.jsonparse.treemodels;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lol.gilliard.jsonparse.SourceData;

import java.io.IOException;

public class JacksonTreeModel {

    // ObjectMapper is stateless and thread-safe so it's OK to create one like this
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        JsonNode neoJsonNode = mapper.readTree(SourceData.asString());

        System.out.println("NEO count: " + getNeoCount(neoJsonNode));

        System.out.println("Potentially hazardous asteroids: " +
            getPotentiallyHazardousAsteroidCount(neoJsonNode));

        NeoNameAndSpeed fastestNEO = getFastestNEO(neoJsonNode);
        System.out.println(
            String.format("Fastest NEO is: %s at %f km/sec",
                fastestNEO.name, fastestNEO.speed));


    }

    private static int getNeoCount(JsonNode neoJsonNode) {
        return neoJsonNode
            .get("element_count")
            .asInt();
    }

    private static int getPotentiallyHazardousAsteroidCount(JsonNode neoJsonNode) {
        int potentiallyHazardousAsteroidCount = 0;
        JsonNode nearEarthObjects = neoJsonNode.get("near_earth_objects");
        for (JsonNode neoClosestApproachDate : nearEarthObjects) {
            for (JsonNode neo : neoClosestApproachDate) {
                if (neo.get("is_potentially_hazardous_asteroid").asBoolean()) {
                    potentiallyHazardousAsteroidCount += 1;
                }
            }
        }
        return potentiallyHazardousAsteroidCount;
    }

    private static NeoNameAndSpeed getFastestNEO(JsonNode neoJsonNode) {
        NeoNameAndSpeed fastestNEO = null;
        JsonNode nearEarthObjects = neoJsonNode.get("near_earth_objects");
        for (JsonNode neoClosestApproachDate : nearEarthObjects) {
            for (JsonNode neo : neoClosestApproachDate) {
                double speed = neo
                    .get("close_approach_data")
                    .get(0)
                    .get("relative_velocity")
                    .get("kilometers_per_second")
                    .asDouble();
                if ( fastestNEO == null ||  speed > fastestNEO.speed ){
                    fastestNEO = new NeoNameAndSpeed(neo.get("name").asText(), speed);
                }
            }
        }
        return fastestNEO;
    }

}
