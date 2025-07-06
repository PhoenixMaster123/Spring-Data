package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        // String inputSize = scanner.nextLine();
        //int inputLabel = Integer.parseInt(scanner.nextLine());
        //BigDecimal price = BigDecimal.valueOf(Integer.parseInt(scanner.nextLine()));

        // Query 1:
        // List<Shampoo> shampooList = shampooService.getShampoosBySize(inputSize);

        // Query 2:
        //List<Shampoo> shampooList = shampooService.getShampoosBySizeOrLabel(inputSize, inputLabel);

        // Query 3:
        //List<Shampoo> shampooList = shampooService.getMoreExpensive(price);
        //shampooList.forEach(System.out::println);

        // Query 4:
        //String prefix = scanner.nextLine();
        //List<Ingredient> autocompleteOptions = ingredientService.getAutocompleteOptions(prefix);

        // Query 5:
        //String[] prefix = scanner.nextLine().split(", ");
        //List<Ingredient> ingredients = ingredientService.findAll(prefix);
        //ingredients.forEach(System.out::println);

        // Query 6:
        // BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        // Integer shampoos = shampooService.countAll(price);
        // System.out.println(shampoos);

        // Query 7:
        // String[] names = scanner.nextLine().split(", ");
        // List<Shampoo> shampoos = shampooService.findByIngredient(names);
        // shampoos.forEach(System.out::println);

        // Query 8:
        //int count = Integer.parseInt(scanner.nextLine());
        //List<Shampoo> shampoos = shampooService.findByIngredientsCount(count);
        //shampoos.forEach(System.out::println);

        // Query 9:
        //String name = scanner.nextLine();
        //ingredientService.delete(name);

        // Query 10:
        //double percentage = Double.parseDouble(scanner.nextLine());
        //ingredientService.updatePriceByPercentage(percentage);

        // Query 11:
        //String[] names = scanner.nextLine().split(", ");
        //double percentage = Double.parseDouble(scanner.nextLine());
        //ingredientService.updatePriceByName(percentage, names);

    }
}
