package bg.softuni.services;

import bg.softuni.data.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void importData() throws IOException;

    Set<Category> getRandomCategories();
}
