package com.manoj.movie.details.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String country;
    private String area;
    private String city;
    private String street;
    private String number;

    public Address() {
    }

    public Address(String country, String area, String city, String street, String number) {
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.number = number;
    }


   @JsonIgnore
   @OneToOne(
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id", referencedColumnName = "id",nullable = false)
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}