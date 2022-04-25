package com.example.libraryapplication.service.impl;

import com.example.libraryapplication.model.Country;
import com.example.libraryapplication.model.exceptions.CountryNotFoundException;
import com.example.libraryapplication.repository.CountryRepository;
import com.example.libraryapplication.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.ofNullable(this.countryRepository.findById(id).orElseThrow(CountryNotFoundException::new));
    }



}
