package bg.softuni.bookshopsystem.dtos;

import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.entities.Category;

import java.util.List;

public class BookRelationsDTO {
    private final Author author;
    private final List<Category> category;

    public BookRelationsDTO(Author author, List<Category> category) {
        this.author = author;
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Category> getCategory() {
        return category;
    }
}
