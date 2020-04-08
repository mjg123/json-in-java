package lol.gilliard.jsonparse.databinding.complex.gson;

import lol.gilliard.jsonparse.databinding.complex.gson.generated.NeoWsDataGson;
import com.google.gson.GsonBuilder;
import lol.gilliard.jsonparse.SourceData;
import lol.gilliard.jsonparse.databinding.complex.gson.generated.NeoDetails;
import lol.gilliard.jsonparse.databinding.simple.GsonLocalDateAdapter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;

public class ComplexDataBindingGson {

    public static void main(String[] args) {

        NeoWsDataGson neoWsDataGson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new GsonLocalDateAdapter())
            .create()
            .fromJson(SourceData.asString(), NeoWsDataGson.class);


        System.out.println("NEO count: " + neoWsDataGson.elementCount);


        System.out.println("Potentially hazardous asteroids: " +
            neoWsDataGson.nearEarthObjects.values()
                .stream().flatMap(Collection::stream) // this converts a Collection of Collections of objects into a single stream
                .filter(neo -> neo.isPotentiallyHazardousAsteroid)
                .count());


        NeoDetails fastestNeo = neoWsDataGson.nearEarthObjects.values()
            .stream().flatMap(Collection::stream)
            .max(Comparator.comparing(neo -> neo.closeApproachData.get(0).relativeVelocity.kilometersPerSecond))
            .get();

        System.out.println(String.format("Fastest NEO is: %s at %f km/sec",
            fastestNeo.name, fastestNeo.closeApproachData.get(0).relativeVelocity.kilometersPerSecond));

    }
}
