package bg.softuni.bookshopsystem.repositories;

import bg.softuni.bookshopsystem.dtos.AuthorSummaryDTO;
import bg.softuni.bookshopsystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findDistinctByBooksReleaseDateLessThan(LocalDate releaseDate);

    @Query("SELECT a.firstName, a.lastName, SIZE(a.books) AS booksCount FROM Author a ORDER BY SIZE(a.books) DESC")
    List<AuthorSummaryDTO> getSummary();
}
