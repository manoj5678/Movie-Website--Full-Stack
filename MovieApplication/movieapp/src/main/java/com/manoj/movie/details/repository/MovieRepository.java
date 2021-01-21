package com.manoj.movie.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manoj.movie.details.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
