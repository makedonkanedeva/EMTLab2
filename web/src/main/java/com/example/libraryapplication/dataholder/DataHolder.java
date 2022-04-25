package com.example.libraryapplication.dataholder;

import com.example.libraryapplication.model.Author;
import com.example.libraryapplication.model.Book;
import com.example.libraryapplication.model.Category;
import com.example.libraryapplication.model.Country;
import com.example.libraryapplication.repository.AuthorRepository;
import com.example.libraryapplication.repository.BookRepository;
import com.example.libraryapplication.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("USA", "North America");
        Country country3 = new Country("Kenya", "Afrika");
        Country country4 = new Country("China", "Asia");
        Country country5 = new Country("France", "Europe");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);
        this.countryRepository.save(country5);

        Author author1 = new Author("William", "Shakespeare", country1);
        Author author2 = new Author("Agatha", "Christie", country3);
        Author author3 = new Author("Harold", "Robbins", country2);
        Author author4 = new Author("Jin", "Yong", country4);
        Author author5 = new Author("Danielle", "Steel", country4);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);
        this.authorRepository.save(author4);
        this.authorRepository.save(author5);

        Book book1 = new Book("The Tragedy Of Macbeth", Category.NOVEL, author1, 14);
        Book book2 = new Book("The Tragedie of Romeo and Juliet", Category.BIOGRAPHY,author1, 200);
        Book book3 = new Book("Thirteen Problems", Category.CLASSICS,author2, 165);
        Book book4 = new Book("And Then There Were None", Category.THRILLER,author2, 35);
        Book book5 = new Book("The Lonely Lady", Category.BIOGRAPHY,author3, 15);
        Book book6 = new Book("Never love a stranger", Category.NOVEL,author3, 56);
        Book book7 = new Book("A deadly secret", Category.CLASSICS, author4, 110);
        Book book8 = new Book("Ode to Gallantry", Category.THRILLER, author4, 72);
        Book book9 = new Book("Zoya", Category.NOVEL, author5, 175);
        Book book10 = new Book("Nine Lives", Category.THRILLER,author5, 27);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
        this.bookRepository.save(book7);
        this.bookRepository.save(book8);
        this.bookRepository.save(book9);
        this.bookRepository.save(book10);
    }
}
