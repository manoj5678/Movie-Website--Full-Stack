package com.manoj.movie.details.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password="WelCome_2020";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL)
    private Role role;

    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL)
    private Contact userContactDetails;

    public User() {
    }

    public User(String name, String email, Role roles, Contact userContactDetails) {
        this.name = name;
        this.email = email;
        this.role = roles;
        this.userContactDetails = userContactDetails;
    }

    public long getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Contact getUserContactDetails() {
        return userContactDetails;
    }

    public void setUserContactDetails(Contact userContactDetails) {
        this.userContactDetails = userContactDetails;
    }
}
