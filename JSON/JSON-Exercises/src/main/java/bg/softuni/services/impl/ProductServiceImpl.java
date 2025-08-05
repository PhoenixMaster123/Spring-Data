package bg.softuni.services.impl;

import bg.softuni.data.entities.Product;
import bg.softuni.data.entities.User;
import bg.softuni.data.repositories.ProductRepository;
import bg.softuni.services.CategoryService;
import bg.softuni.services.ProductService;
import bg.softuni.services.UserService;
import bg.softuni.services.dtos.ImportProductDto;
import bg.softuni.services.dtos.UnsolvedProductInfoDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.gson = new GsonBuilder().setPrettyPrinting().create();

    }
    @Override
    public void importData() throws IOException { // In real example, we will have importData(List<ImportProductDto> importProductDtos) method
        Path jsonFilePath = Path.of("src/main/resources/json_data/products.json");
        List<String> lines = Files.readAllLines(jsonFilePath);

        ImportProductDto[] fromJson = this.gson.fromJson(String.join("", lines), ImportProductDto[].class);

        for (ImportProductDto importProductDto : fromJson) {
            // Validate the name field
            if (importProductDto.getName() == null || importProductDto.getName().trim().isEmpty() || importProductDto.getName().length() < 3) {
                System.out.println("Invalid product name: " + importProductDto.getName());
                continue;
            }

            // Convert DTO to Entity
            Product product = this.modelMapper.map(importProductDto, Product.class);

            product.setSeller(this.getRandomUser(false));
            product.setBuyer(this.getRandomUser(true));
            product.setCategories(this.categoryService.getRandomCategories());

            // Save to the database
            this.productRepository.save(product);
        }
    }

    @Override
    public void getUnsoldProductsInRange(double lowerBound, double upperBound) {

        List<Product> products = this.productRepository.findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal.valueOf(lowerBound), BigDecimal.valueOf(upperBound));

        // Better -> with TypeMapper
        List<UnsolvedProductInfoDto> result = new ArrayList<>();

        for( Product product : products) {
            result.add(new UnsolvedProductInfoDto(product));
        }
        String json = this.gson.toJson(result);
        System.out.println(json);
    }

    private User getRandomUser(boolean canReturnNull) {
        Random random = new Random();

        if(canReturnNull) {
            boolean shouldReturnNull = random.nextBoolean();

        if (shouldReturnNull) {
                return null;
            }
        }
        return this.userService.getRandomUser();
    }
}
