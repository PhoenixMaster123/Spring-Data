package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.dtos.AuthorDTO;
import bg.softuni.bookshopsystem.dtos.AuthorSummaryDTO;
import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.entities.Book;

import java.util.List;

public interface AuthorService {
    Author create(AuthorDTO authorDto);

    List<Author> findActiveBefore(int year);

    List<AuthorSummaryDTO> getSummary();
}
