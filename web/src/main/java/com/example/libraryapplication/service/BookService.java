package com.example.libraryapplication.service;

import com.example.libraryapplication.model.Author;
import com.example.libraryapplication.model.Book;
import com.example.libraryapplication.model.Category;
import com.example.libraryapplication.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> findById(Long id);

    Optional<Book> create(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> create(String name, Category category, Author author, Integer availableCopies);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);
}
