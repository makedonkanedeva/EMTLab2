package com.example.libraryapplication.service;

import com.example.libraryapplication.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);



}
