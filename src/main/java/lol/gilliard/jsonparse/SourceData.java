package lol.gilliard.jsonparse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SourceData {

    public static String asString(){
        try {
            Stream<String> lines = Files.lines(
                Paths.get(ClassLoader.getSystemResource("source.json").toURI()));

            return lines.collect(Collectors.joining());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
