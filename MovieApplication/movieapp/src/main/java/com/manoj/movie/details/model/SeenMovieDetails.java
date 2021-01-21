package com.manoj.movie.details.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SeenMovies")
public class SeenMovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date watchedDate;
    private long movieId;
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public SeenMovieDetails() {
    }

    public SeenMovieDetails(Date watchedDate, long movieId, long userId) {
        this.watchedDate = watchedDate;
        this.movieId = movieId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWatchedDate() {
        return watchedDate;
    }

    public void setWatchedDate(Date watchedDate) {
        this.watchedDate = watchedDate;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
