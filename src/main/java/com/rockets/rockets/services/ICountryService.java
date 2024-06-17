package com.rockets.rockets.services;

import com.rockets.rockets.entities.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    List<Country> getAllCountries();

    Optional<Country> getCountryById(Long countryId);

    void saveCountry(Country newCountry);

    void deleteCountry(Country countryToDelete);
}
