package com.example.libraryapplication.service.impl;

import com.example.libraryapplication.model.Author;
import com.example.libraryapplication.model.Book;
import com.example.libraryapplication.model.Category;
import com.example.libraryapplication.model.dto.BookDto;
import com.example.libraryapplication.model.exceptions.AuthorDoesNotExistException;
import com.example.libraryapplication.model.exceptions.BookDoesNotExistException;
import com.example.libraryapplication.model.exceptions.NoMoreCopiesException;
import com.example.libraryapplication.repository.AuthorRepository;
import com.example.libraryapplication.repository.BookRepository;
import com.example.libraryapplication.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorDoesNotExistException::new);
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(AuthorDoesNotExistException::new);
        book.setAuthor(author);
        Category category = Category.valueOf(bookDto.getCategory().toString());
        book.setCategory(category);
        book.setName(bookDto.getName());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> create(String name, Category category, Author author, Integer availableCopies) {
        return Optional.of(this.bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }


    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);
        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies == 0){
            throw new NoMoreCopiesException();
        }
        availableCopies -= 1;
        book.setAvailableCopies(availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }
}
