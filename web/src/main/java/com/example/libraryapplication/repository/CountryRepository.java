package com.example.libraryapplication.repository;

import com.example.libraryapplication.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
