package com.rockets.rockets.services;

import com.rockets.rockets.entities.Country;
import com.rockets.rockets.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService{

    private CountryRepository countryRepository;

    @Autowired
    CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long countryId){
        return countryRepository.findById(countryId);
    }

    @Override
    public void saveCountry(Country newCountry){
        countryRepository.save(newCountry);
    }

    @Override
    public void deleteCountry(Country countryToDelete){
        countryRepository.delete(countryToDelete);
    }
}
