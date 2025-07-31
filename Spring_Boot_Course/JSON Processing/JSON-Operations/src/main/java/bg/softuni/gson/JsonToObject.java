package bg.softuni.gson;

import bg.softuni.gson.dto.PersonDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToObject {
    public static void main(String[] args) {
        // Java Json to Object (using Gson)

        String json = """
                {
                  "firstName": "John",
                  "lastName": "Doe",
                  "age": 30,
                  "isMarried": true,
                  "birthDate": "2025-07-31",
                  "address": {
                    "country": "Bulgaria",
                    "city": "Sofia",
                    "street": "Vitosha Blvd."
                  },
                  "hobbies": ["Reading", "Traveling", "Cooking"]
                }
                """;

        // Convert JSON string to PersonDto object
        Gson gsonBuilder = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // Shows only fields that are annotated with @Expose
                .setPrettyPrinting() // Easy readable JSON
                .setDateFormat("yyyy-MM-dd") // Format for Date
                .serializeNulls() // Include null fields in JSON (if a field is null, it will be included in the JSON) otherwise it will be omitted
                .create(); // Create Gson instance with the specified settings

        PersonDto person = gsonBuilder.fromJson(json, PersonDto.class);
        //System.out.println(person);

        // Note: We don't @Expose isMarried field and it will take the default value of false

        // Json -> List of objects
        String jsonList = """
                [
                  {
                    "firstName": "John",
                    "lastName": "Doe",
                    "age": 30,
                    "isMarried": true,
                    "birthDate": "2025-07-31",
                    "address": {
                      "country": "Bulgaria",
                      "city": "Sofia",
                      "street": "Vitosha Blvd."
                    },
                    "hobbies": ["Reading", "Traveling", "Cooking"]
                  },
                  {
                    "firstName": "Jane",
                    "lastName": "Smith",
                    "age": 25,
                    "isMarried": false,
                    "birthDate": "2025-01-01",
                    "address": {
                      "country": "USA",
                      "city": "New York",
                      "street": "5th Ave"
                    },
                    "hobbies": ["Swimming", "Running"]
                  }
                ]
                """;
        PersonDto[] persons = gsonBuilder.fromJson(jsonList, PersonDto[].class);
        for (PersonDto p : persons) {
            System.out.println(p);
        }
    }
}
