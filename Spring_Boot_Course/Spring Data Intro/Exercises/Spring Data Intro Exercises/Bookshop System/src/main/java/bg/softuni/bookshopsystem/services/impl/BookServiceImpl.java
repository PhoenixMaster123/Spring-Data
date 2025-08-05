package bg.softuni.bookshopsystem.services.impl;

import bg.softuni.bookshopsystem.dtos.BookDTO;
import bg.softuni.bookshopsystem.dtos.BookRelationsDTO;
import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.repositories.BookRepository;
import bg.softuni.bookshopsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(BookDTO bookDTO, BookRelationsDTO bookRelationsDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setCopies(bookDTO.getCopies());
        book.setPrice(bookDTO.getPrice());
        book.setReleaseDate(bookDTO.getReleaseDate());
        book.setEditionType(bookDTO.getEditionType());
        book.setAgeRestriction(bookDTO.getAgeRestriction());

        book.setAuthor(bookRelationsDTO.getAuthor());
        book.setCategories(Set.copyOf(bookRelationsDTO.getCategory()));

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findReleasedAfter(int year) {
        LocalDate releaseDate = LocalDate.of(year, 1, 1);
        return bookRepository.findAllByReleaseDateGreaterThanEqual(releaseDate);
    }

    @Override
    public List<Book> findByAuthor(String firstName, String lastName) {
        return bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);
    }
}
