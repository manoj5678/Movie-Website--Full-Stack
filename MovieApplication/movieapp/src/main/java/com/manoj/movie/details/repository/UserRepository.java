package com.manoj.movie.details.repository;

import com.manoj.movie.details.model.Movie;
import com.manoj.movie.details.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    User findByEmailAndPassword(String email, String password);

}
