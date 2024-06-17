package com.rockets.rockets.controllers;

import com.rockets.rockets.entities.Country;
import com.rockets.rockets.services.ICountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class CountryController {

    private final ICountryService countryService;

    @Autowired
    CountryController(ICountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Say Hello from /countries";
    }

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> all(){
        try{
            return ResponseEntity.ok().body(countryService.getAllCountries());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @PostMapping("/countries")
    public ResponseEntity<Object> addNewCountry(@RequestParam("name") String countryName, @RequestParam("code") String countryCode){
        HashMap<String,Object> response = new HashMap<>();
        try{
            Country country = new Country(countryName,countryCode);
            countryService.saveCountry(country);
            response.put("result",country.toString());
            return ResponseEntity.ok().body(response);
        }
        catch (Exception ex){
            response.put("message","Could not create country");
            return ResponseEntity.badRequest().body(response);
        }

    }

    @PostMapping("/countries/body")
    public ResponseEntity<Object> addNewCountry(@RequestBody Map<String,Object> body){
        HashMap<String,Object> response = new HashMap<>();
        System.out.println(body);
        System.out.println(body.get("name"));
        try{
            Country newCountry = new Country(body.get("name").toString(),body.get("code").toString());
            countryService.saveCountry(newCountry);
            response.put("result",newCountry);
            return ResponseEntity.ok().body(newCountry);
        }
        catch (Exception ex){
            response.put("message","Could not create country");
            return ResponseEntity.badRequest().body(response);
        }

    }
    }

