package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.dtos.*;
import bg.softuni.bookshopsystem.entities.Author;
import bg.softuni.bookshopsystem.entities.Book;
import bg.softuni.bookshopsystem.entities.Category;
import bg.softuni.bookshopsystem.enums.AgeRestriction;
import bg.softuni.bookshopsystem.enums.EditionType;
import bg.softuni.bookshopsystem.services.AuthorService;
import bg.softuni.bookshopsystem.services.BookService;
import bg.softuni.bookshopsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public Runner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        // This is where you can implement your logic to interact with the database

        List<String> categoryLines = readSeedFiles("categories.txt");
        List<Category> categories = new ArrayList<>();
        for (String categoryName : categoryLines) {
            Category currentCategory = categoryService.create(new CategoryDTO(categoryName));
            categories.add(currentCategory);
        }

        List<String> authorLines = readSeedFiles("authors.txt");
        List<Author> authors = new ArrayList<>();
        for (String authorName : authorLines) {
            String[] names = authorName.split("\\s+");
            String firstName = names[0];
            String lastName = names[1];
            Author currentAuthor = authorService.create(new AuthorDTO(firstName, lastName));
            authors.add(currentAuthor);
        }

        List<String> bookLines = readSeedFiles("books.txt");
        for(String line : bookLines) {
            String[] data = line.split("\\s+");

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            Long copies = Long.parseLong(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));

            // Randomly select an author [0, authors.size())
            int randomAuthorIndex = ThreadLocalRandom.current().nextInt(0, authors.size());
            Author randomAuthor = authors.get(randomAuthorIndex);

            // Randomly select categories
            int randomCategoriesCount = ThreadLocalRandom.current().nextInt(0, 3); // 0 to 2 categories
            List<Category> randomCategories = new ArrayList<>();

            for (int i = 0; i < randomCategoriesCount; i++) {
                int randomCategoryIndex = ThreadLocalRandom.current().nextInt(0, categories.size());
                randomCategories.add(categories.get(randomCategoryIndex));
            }

            BookDTO bookDTO = new BookDTO(
                    title,
                    copies,
                    price,
                    editionType,
                    releaseDate,
                    ageRestriction
            );

            BookRelationsDTO bookRelationsDTO = new BookRelationsDTO(randomAuthor, randomCategories);
            bookService.create(bookDTO, bookRelationsDTO);
        }

        // 1. Read seed files
        // 2. Seed data into the database
        // 3. Perform operations like querying, updating, deleting entities

        // First Query: Find all books released after 2000
        List<Book> books = bookService.findReleasedAfter(2000);
        books.forEach(book -> System.out.printf("Title: %s%n", book.getTitle()));

        // Second Query: Find all authors who have books released before 1990
        List<Author> authorsBefore1990 = authorService.findActiveBefore(1990);
        authorsBefore1990.forEach(author -> System.out.printf("Author: %s %s%n", author.getFirstName(), author.getLastName()));

        // Third Query: Find all authors ordered by the number of books they have written in descending order
        List<AuthorSummaryDTO> productionStatistics = authorService.getSummary();
        productionStatistics.forEach(authorSummary ->
            System.out.printf("%s %s - %d\n",
                authorSummary.getFirstName(),
                authorSummary.getLastName(),
                authorSummary.getBooksCount())
        );

        // Fourth Query: Find all books by a specific author and order them by release date and title
        List<Book> booksByAuthor = bookService.findByAuthor("George", "Powell");
        booksByAuthor.forEach(book -> System.out.printf("%s (%s) - %d%n", book.getTitle(), book.getReleaseDate(), book.getCopies()));
    }
    private List<String> readSeedFiles(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource(fileName);

        try( InputStream inputStream = resource.getInputStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.lines().toList();
        }
    }
}
