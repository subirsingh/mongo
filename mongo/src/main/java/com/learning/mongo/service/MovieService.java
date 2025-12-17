package com.learning.mongo.service;

import com.learning.mongo.model.Movie;
import com.learning.mongo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        List<Movie> movieList = new ArrayList<>();
        long count =0;
        try {
              count = movieRepository.count();
             // movieList = movieRepository.getAllMovies();
              movieList = movieRepository.findAll();
              log.info("Total movies are :{}",count);
        }catch (Exception ex){
            log.info("Exception while fetching data:{}",ex.getStackTrace());
        }
        return movieList;
    }
}
