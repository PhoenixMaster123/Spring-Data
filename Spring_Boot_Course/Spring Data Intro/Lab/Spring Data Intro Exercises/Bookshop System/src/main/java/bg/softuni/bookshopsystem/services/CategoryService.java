package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.dtos.CategoryDTO;
import bg.softuni.bookshopsystem.entities.Category;

public interface CategoryService {
    Category create(CategoryDTO categoryDto);
}
