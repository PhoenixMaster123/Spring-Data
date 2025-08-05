package bg.softuni.services.impl;

import bg.softuni.data.entities.Category;
import bg.softuni.data.repositories.CategoryRepository;
import bg.softuni.services.CategoryService;
import bg.softuni.services.dtos.ImportCategoryDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, ModelMapper modelMapper) {
        this.categoryRepository = repository;
        this.modelMapper = modelMapper;
        this.gson = new GsonBuilder().create();
    }
    @Override
    public void importData() throws IOException {
        Path filePath = Path.of("src/main/resources/json_data/categories.json");

        List<String> lines = Files.readAllLines(filePath);
        ImportCategoryDto[] jsonContent = this.gson.fromJson(String.join("", lines), ImportCategoryDto[].class);

        for (ImportCategoryDto categoryDto : jsonContent) {
            if (categoryDto.getName() == null || categoryDto.getName().length() < 3 || categoryDto.getName().length() > 15) {
                System.out.println("Invalid category: " + categoryDto.getName());
                continue;
            }

            // Convert DTO to Entity
            Category category = this.modelMapper.map(categoryDto, Category.class);

            // Save to the database
            this.categoryRepository.save(category);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();

         long totalCategories = this.categoryRepository.count();
         long randomCount = random.nextLong(totalCategories);

        if (randomCount == 0) {
            randomCount = 1; // Ensure at least one category is selected
        }

        Set<Category> randomCategories = new HashSet<>();
        for (long i = 0; i < randomCount; i++) {
            long randomId = random.nextLong(totalCategories) + 1; // IDs are 1-based
            this.categoryRepository.findById(randomId).ifPresent(randomCategories::add);
        }
        return randomCategories;
    }
}
