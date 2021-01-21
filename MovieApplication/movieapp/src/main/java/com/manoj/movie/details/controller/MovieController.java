package com.manoj.movie.details.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.manoj.movie.details.model.User;
import com.manoj.movie.details.repository.MovieRepository;
import com.manoj.movie.details.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.manoj.movie.details.exception.ResourceNotFoundException;
import com.manoj.movie.details.model.Movie;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/movieDetails")
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}


	@PostMapping("/validateUser")
	public User validateUserDetails(@Valid @RequestBody User user){
		User userDetails = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        System.out.println("called the validate method");
		return userDetails;
	}
	@GetMapping("/movieDetail/{movieId}")
	public ResponseEntity<Movie> getEmployeeById(@PathVariable(value = "movieId") Long movieId)
			throws ResourceNotFoundException {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + movieId));
		return ResponseEntity.ok().body(movie);
	}

}
