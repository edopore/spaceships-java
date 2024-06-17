package com.rockets.rockets.repositories;

import com.rockets.rockets.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
