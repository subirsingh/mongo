package com.learning.mongo.controller;

import com.learning.mongo.model.Movie;
import com.learning.mongo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MongoController {

    private final MovieService movieService;

    @GetMapping("/getMovies")
    public List<Movie> getMovieDetails(){
        List<Movie> movieList = movieService.getAllMovies();
        return movieList;
    }
}
