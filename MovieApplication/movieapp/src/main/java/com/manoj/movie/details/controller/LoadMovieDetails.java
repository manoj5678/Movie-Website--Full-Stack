package com.manoj.movie.details.controller;

import com.manoj.movie.details.model.Movie;
import com.manoj.movie.details.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class LoadMovieDetails implements ApplicationRunner {

    @Autowired
    private  MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Movie> movieList  =  new ArrayList<>();

        String[] movieArray = {"Parasite","Tenet","Onward","The Invisible Man","Birds Of Prey","Little Women","The Gentlemen","Jojo Rabbit","Richard Jewell"};

        for (int i=0; i <=7 ; i++){
            movieList.add(new Movie(movieArray[i],
                        new Date(),
                    movieArray[0]+" Kang Ho Song,Sung Hi Lee,Yeo-Jeong Jo,Woo-Sik Choi,So-Dam Park With an insightful and searing exploration of human behavior, ‘Parasite’ is a masterfully crafted film that is a definite must watch"));
        }
        movieRepository.saveAll(movieList);

    }
}
