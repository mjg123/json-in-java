package lol.gilliard.jsonparse.databinding.complex.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lol.gilliard.jsonparse.SourceData;
import lol.gilliard.jsonparse.databinding.complex.jackson.generated.NeoDetails;
import lol.gilliard.jsonparse.databinding.complex.jackson.generated.NeoWsDataJackson;

import java.util.Collection;
import java.util.Comparator;

public class ComplexDataBindingJackson {

    public static void main(String[] args) throws JsonProcessingException {
        NeoWsDataJackson neoWsDataJackson = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .readValue(SourceData.asString(), NeoWsDataJackson.class);


        System.out.println("NEO count: " + neoWsDataJackson.elementCount);


        System.out.println("Potentially hazardous asteroids: " +
            neoWsDataJackson.nearEarthObjects.values()
                .stream().flatMap(Collection::stream) // this converts a Collection of Collections of objects into a single stream
                .filter(neo -> neo.isPotentiallyHazardousAsteroid)
                .count());


        NeoDetails fastestNeo = neoWsDataJackson.nearEarthObjects.values()
            .stream().flatMap(Collection::stream)
            .max( Comparator.comparing( neo -> neo.closeApproachData.get(0).relativeVelocity.kilometersPerSecond ))
            .get();

        System.out.println(String.format("Fastest NEO is: %s at %f km/sec",
            fastestNeo.name, fastestNeo.closeApproachData.get(0).relativeVelocity.kilometersPerSecond));

    }
}
