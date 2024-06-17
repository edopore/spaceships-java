package com.rockets.rockets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long countryId;

    @Column(name = "name")
    private String countryName;

    @Column(name = "code")
    private String countryCode;

    public Country(String countryName, String countryCode){
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Employee{" + "countryId=" + this.countryId + ", countryName='" + this.countryName + '\'' + ", countryCode='" + this.countryCode + '\'' + '}';
    }
}
