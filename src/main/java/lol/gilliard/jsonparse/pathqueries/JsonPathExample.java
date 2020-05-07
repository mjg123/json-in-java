package lol.gilliard.jsonparse.pathqueries;

import com.jayway.jsonpath.JsonPath;
import lol.gilliard.jsonparse.SourceData;
import net.minidev.json.JSONArray;

public class JsonPathExample {

    public static void main(String[] args) {

        int neoCount = JsonPath.read(SourceData.asString(), "$.element_count");
        System.out.println("NEO count: " + neoCount);

        JSONArray potentiallyHazardousNeos = JsonPath.read(SourceData.asString(),
            "$..[?(@.is_potentially_hazardous_asteroid==true)]");
        System.out.println("Potentially hazardous asteroids: " + potentiallyHazardousNeos.size());

    }

}
