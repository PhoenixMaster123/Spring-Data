package bg.softuni.bookshopsystem.services.impl;

import bg.softuni.bookshopsystem.dtos.CategoryDTO;
import bg.softuni.bookshopsystem.entities.Category;
import bg.softuni.bookshopsystem.repositories.CategoryRepository;
import bg.softuni.bookshopsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryDTO categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        return categoryRepository.save(category);
    }
}
