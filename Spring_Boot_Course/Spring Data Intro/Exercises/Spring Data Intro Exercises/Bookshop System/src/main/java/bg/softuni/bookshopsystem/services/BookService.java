package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.dtos.BookDTO;
import bg.softuni.bookshopsystem.dtos.BookRelationsDTO;
import bg.softuni.bookshopsystem.entities.Book;

import java.util.List;

public interface BookService {
    Book create(BookDTO bookDTO, BookRelationsDTO bookRelationsDTO);

    List<Book> findReleasedAfter(int year);
    List<Book> findByAuthor(String firstName, String lastName);
}
