package com.manoj.movie.details.repository;

import com.manoj.movie.details.model.SeenMovieDetails;
import com.manoj.movie.details.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface SeenMoviesRepository extends JpaRepository<SeenMovieDetails, Long>{

   }
