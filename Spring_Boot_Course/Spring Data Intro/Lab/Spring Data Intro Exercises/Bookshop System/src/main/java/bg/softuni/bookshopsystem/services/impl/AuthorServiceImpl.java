package bg.softuni.bookshopsystem.services.impl;

import bg.softuni.bookshopsystem.dtos.AuthorDTO;
import bg.softuni.bookshopsystem.dtos.AuthorSummaryDTO;
import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.repositories.AuthorRepository;
import bg.softuni.bookshopsystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(AuthorDTO authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());

        return authorRepository.save(author);
    }

    @Override
    public List<Author> findActiveBefore(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        return authorRepository.findDistinctByBooksReleaseDateLessThan(date);
    }

    @Override
    public List<AuthorSummaryDTO> getSummary() {
        return authorRepository.getSummary();
    }
}
