package com.example.libraryapplication.service;

import com.example.libraryapplication.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> listAll();

    Optional<Country> findById(Long id);


}
