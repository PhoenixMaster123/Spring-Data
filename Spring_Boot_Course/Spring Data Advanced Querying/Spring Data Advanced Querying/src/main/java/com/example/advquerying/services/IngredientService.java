package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAutocompleteOptions(String prefix) {
        if (prefix == null || prefix.isBlank()) {
            throw new IllegalArgumentException("Prefix cannot be null or empty.");
        }
        return ingredientRepository.findByNameStartingWith(prefix);
    }

    public List<Ingredient> findAll(String[] names) {
        List<String> namesList = Arrays.asList(names);

        return ingredientRepository.findByNameInOrderByPrice(namesList);
    }

    @Transactional // Ensures that the delete operation is performed within a transaction
    public void delete(String name) {
        // getTransaction().begin(); // Not needed, @Transactional handles it
        ingredientRepository.deleteByName(name);
        // getTransaction().commit(); // Not needed, @Transactional handles it
    }

    public void updatePriceByPercentage(double percentage) {
        ingredientRepository.updatePriceByPercentage(percentage);
    }

    public void updatePriceByName(double percentage, String[] names) {
        List<String> namesList = Arrays.asList(names);
        ingredientRepository.updatePriceByName(percentage, namesList);
    }
}
