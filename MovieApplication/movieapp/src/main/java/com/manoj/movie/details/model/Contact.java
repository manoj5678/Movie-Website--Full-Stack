package com.manoj.movie.details.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String gender;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    public Contact() {
    }

    public Contact(String name, String gender, String email, Date birthDate, Address address) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
    }



    @JsonIgnore
    @OneToOne(
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
    private User user;


    @OneToOne(mappedBy = "contact",
            cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}