package com.enviro.assessment.grad001.lawsonmatutu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "investors")

public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
    private Date dateOfBirth;
    @Embedded

    private Address address;
    @JsonIgnore
    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();;

    //private List<Product> products;



    public Investor() {
    }

    public Investor(String firstName, String lastName, String email, String phoneNumber, Address address, List<Product> products,Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.products = products;
        this.dateOfBirth=dateOfBirth;
    }
    public int getAge() {
        LocalDate birthDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }



}
