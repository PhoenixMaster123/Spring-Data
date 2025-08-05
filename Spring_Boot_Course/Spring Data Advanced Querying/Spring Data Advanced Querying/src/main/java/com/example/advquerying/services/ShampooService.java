package com.example.advquerying.services;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ShampooService {
    private final ShampooRepository shampooRepository;
    private final IngredientService ingredientService;

    @Autowired
    public ShampooService(ShampooRepository shampooRepository, IngredientService ingredientService) {
        this.shampooRepository = shampooRepository;
        this.ingredientService = ingredientService;
    }

    public List<Shampoo> getShampoosBySize(String inputSize) {

        Size size;
        try {
            size = Size.valueOf(inputSize.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid size: " + inputSize);
        }
        return shampooRepository.findBySizeOrderByBrandDesc(size);
    }

    public List<Shampoo> getShampoosBySizeOrLabel(String inputSize, int inputLabel) {
        Size size;
        try {
            size = Size.valueOf(inputSize.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid size: " + inputSize);
        }
        return shampooRepository.findBySizeOrLabelId(size, inputLabel);
    }

    public List<Shampoo> getMoreExpensive(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be a positive number.");
        }
        return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    public Integer countAll(BigDecimal price) {
        return shampooRepository.countByPriceLessThan(price);
    }

    public List<Shampoo> findByIngredient(String[] names) {
        List<String> ingredientNames = Arrays.asList(names);

        return shampooRepository.findByIngredientsNameIn(ingredientNames);
    }

    public List<Shampoo> findByIngredientsCount(int count) {
        return shampooRepository.findByIngredientsCountLessThan(count);
    }
}
