package bg.softuni.gson;

import bg.softuni.gson.dto.AddressDto;
import bg.softuni.gson.dto.PersonDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectToJson {
    public static void main(String[] args) {
        // Java object to JSON (using Gson)

        PersonDto person = new PersonDto(
                "John",
                "Doe",
                30,
                true,
                Date.from(Instant.now()),
                new AddressDto("Bulgaria", "Sofia", "Vitosha Blvd."));

        person.setHobbies(List.of("Reading", "Traveling", "Cooking"));

        // Convert the person object to JSON string
        Gson gsonBuilder = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // Shows only fields that are annotated with @Expose
                //.excludeFieldsWithModifiers(Modifier.STATIC) // Exclude static fields from JSON
                .setPrettyPrinting() // Easy readable JSON
                .setDateFormat("yyyy-MM-dd") // Format for Date
                .serializeNulls() // Include null fields in JSON (if a field is null, it will be included in the JSON) otherwise it will be omitted
                .create(); // Create Gson instance with the specified settings

        String json = gsonBuilder.toJson(person);
        // Output: without the @Expose annotation, all fields will be included in the JSON
        /*
        {
          "firstName": "John",
          "lastName": "Doe",
          "age": 30,
          "isMarried": true,
          "birthDate": "2025-07-31"
         */

        // Note: The LocalDate type is not supported by Gson by default.
        // To use LocalDate, you need to register a custom serializer/deserializer for it.
        // GsonBuilder gsonBuilder = new GsonBuilder()
        //         .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
        //         .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
        //         .create();

        // Note: You need to annotate the fields with @Expose if you have nested objects


        // List from objects to JSON

        PersonDto person2 = new PersonDto(
                "Jane",
                "Doe",
                28,
                false,
                Date.from(Instant.now()),
                new AddressDto("USA", "New York", "5th Ave"));
        person2.setHobbies(List.of("Painting", "Hiking"));

        List<PersonDto> listPersons = new ArrayList<>();
        listPersons.add(person);
        listPersons.add(person2);

        String jsonList = gsonBuilder.toJson(listPersons);
        System.out.println(jsonList);
    }
}
