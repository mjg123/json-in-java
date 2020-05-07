package lol.gilliard.jsonparse.pathqueries;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lol.gilliard.jsonparse.SourceData;

public class JacksonJsonPointer {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(SourceData.asString());

        JsonPointer pointer = JsonPointer.compile("/element_count");

        System.out.println("NEO count: " + node.at(pointer).asText());

    }

}
