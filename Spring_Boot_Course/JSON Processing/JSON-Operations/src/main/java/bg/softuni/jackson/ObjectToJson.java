package bg.softuni.jackson;

import bg.softuni.jackson.dto.PersonDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
    public static void main(String[] args) throws JsonProcessingException {
        // Java Object to Json (using Jackson)
        PersonDto person = new PersonDto("John", "Doe", 30, true);

        // Convert PersonDto object to JSON string
        ObjectMapper mapper = new ObjectMapper(); // It uses JsonParser and JsonGenerator under the hood from jackson-core library

        String json = mapper.
                writerWithDefaultPrettyPrinter().
                writeValueAsString(person);
        System.out.println(json);
        // Output:
        /*
        {
          "firstName" : "John",
          "lastName" : "Doe",
          "age" : 30,
          "isMarried" : true
        }
         */

        // Note: Jackson uses getters and setters to serialize and deserialize objects.

        // Features of Jackson:
        // writeValue(File file, Object value) - writes the JSON to a file
        // writeValueAsString(Object value) - converts the object to a JSON string
        // writeValueAsBytes(Object value) - converts the object to a JSON byte array

        // More advanced features:
        // If you want to use custom serialization, you can use annotations like @JsonProperty, @JsonIgnore, @JsonInclude, etc.
        // For example, to ignore a field, you can use @JsonIgnore on the field or getter method.
        // To include only non-null fields, you can use @JsonInclude(JsonInclude.Include.NON_NULL) on the class or field.
        // To include only fields with a specific name, you can use @JsonProperty("name") on the field or getter method.

    }
}
