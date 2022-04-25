package com.example.libraryapplication.repository;

import com.example.libraryapplication.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
