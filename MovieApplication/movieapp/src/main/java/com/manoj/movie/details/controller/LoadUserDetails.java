package com.manoj.movie.details.controller;

import com.manoj.movie.details.model.*;
import com.manoj.movie.details.repository.MovieRepository;
import com.manoj.movie.details.repository.SeenMoviesRepository;
import com.manoj.movie.details.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class LoadUserDetails implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SeenMoviesRepository seenMoviesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<User> userList = new ArrayList<>();
        List<Movie> movies =  movieRepository.findAll();
        List<SeenMovieDetails> seenMovieDetails  = new ArrayList<>();

        String[] users = {"Oliver", "Harry", "George", "Noah", "Jack", "Jacob", "Leo Oscar", "Charli", "Muhammad"};


       for (int i = 0; i <= 7; i++) {
           Role roles =new Role( i%2 ==0? "ADMIN":"NORMAL");
           Address address  =  new Address("US","Round Augasta"+i,"NewYork",i+" street, left side of 20"+i,"23"+i);
            Contact  contact  =  new Contact("Mr."+users[i],"Male","",new Date(),address);
            address.setContact(contact);
            contact.setAddress(address);
            User user = new User(users[i], users[i] + "@gmail.com", roles,contact);
            contact.setUser(user);
            roles.setUser(user);
            user.setRole(roles);
            user.setUserContactDetails(contact);
            userList.add(user);
        }

        userRepository.saveAll(userList);
        List<User> retrivedUserList =   userRepository.findAll();

        movies.stream().forEach(movie -> {
            retrivedUserList.stream().forEach(user -> {
                SeenMovieDetails seenMovieDetail = new SeenMovieDetails(new Date(),user.getId(),movie.getId());
                seenMovieDetails.add(seenMovieDetail);
            });
        });

        seenMoviesRepository.saveAll(seenMovieDetails);
    }
}
