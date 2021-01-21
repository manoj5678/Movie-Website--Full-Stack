package com.manoj.movie.details.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {

    private long id;
    private String title;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public Movie() {
    }


    public Movie(String title, Date addedDate, String description) {
        this.title = title;
        this.addedDate = addedDate;
        this.description = description;
    }

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
