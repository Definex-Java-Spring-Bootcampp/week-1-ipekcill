package com.patika.onlineshoppingservice.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private String name;
    private String surname;
    private String phoneNumber;
    private String city;
    private String country;
    private LocalDate birthDate;

    public Customer(String name, String surname, String phoneNumber, String city, String country, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.birthDate = birthDate;
    }
}
