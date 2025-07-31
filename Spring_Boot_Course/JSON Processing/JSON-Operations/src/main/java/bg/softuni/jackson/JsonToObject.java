package bg.softuni.jackson;

import bg.softuni.jackson.dto.PersonDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObject {
    public static void main(String[] args) throws JsonProcessingException {
        // Json to Java Object (using Jackson)

        String json = """
                {
                  "firstName": "John",
                  "lastName": "Doe",
                  "age": 30,
                  "isMarried": true
                }
                """;

        ObjectMapper mapper = new ObjectMapper();
        PersonDto person = mapper.readValue(json, PersonDto.class);
        System.out.println(person);

        // Note: Needs the default constructor to deserialize the object.

        // Features of Jackson:
        // readValue(byte[] content, Class<T> valueType) - reads the JSON from a byte array and converts it to an object
        // readValue(String content, Class<T> valueType) - reads the JSON from a string and converts it to an object
        // readValue(File file, Class<T> valueType) - reads the JSON from a file and converts it to an object
        // readTree(String content) - reads the JSON from a string and converts it to a JsonNode object
        // readTree(byte[] content) - reads the JSON from a byte array and converts it to a JsonNode object
        // readTree(File file) - reads the JSON from a file and converts it to a JsonNode object
        // readValue(JsonParser p, Class<T> valueType) - reads the JSON from a JsonParser and converts it to an object
        // readValue(JsonNode node, Class<T> valueType) - reads the JSON from a JsonNode and converts it to an object
    }
}
