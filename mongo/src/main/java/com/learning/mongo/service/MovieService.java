package com.learning.mongo.service;

import com.learning.mongo.model.Movie;
import com.learning.mongo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;
    private final ExecutorService virtualThreadService;

    public List<Movie> getAllMovies(){
        List<Movie> movieList = new ArrayList<>();
        long startTime = System.nanoTime();
        try {
               log.info("start fetching movies by all..........................................");
              movieList.addAll(movieRepository.findAll());
                log.info("Movies fetch by All");
        }catch (Exception ex){
            log.info("Exception while fetching data:{}",ex.getStackTrace());
        }
     long endTime = System.nanoTime();
     long durationInMillis = (endTime - startTime) / 1_000_000;
     log.info("Total time taken to fetch the movie data without virtual thread is :{} ms",durationInMillis);
        return movieList;
    }
    public List<Movie> getAllMoviesByVirtualThread(){
        List<Movie> movieList = new ArrayList<>();
        List<Movie> fetchByAll = new ArrayList<>();
        long startTime = System.nanoTime();
        try {

          var futureCount = virtualThreadService.submit(()->{
               log.info("start fetching count..................................................");
                var count = movieRepository.count();
                log.info("Total movies are :{}",count);
            });

          var futureAllMovies = virtualThreadService.submit(()->{
               log.info("start fetching all movies.............................................");
               List<Movie> allMoviesList = movieRepository.getAllMovies();
                fetchByAll.addAll(allMoviesList);
                log.info("All Movies fetched");
            });

            var futureMoviesByAll = virtualThreadService.submit(()->{
                log.info("virtual start fetching movies by all..........................................");
                List<Movie> byAllMoviesList = movieRepository.findAll();
                movieList.addAll(byAllMoviesList);
                log.info("virtual Movies fetch by All");
            });
             futureCount.get();
             futureAllMovies.get();
            futureMoviesByAll.get();
        }catch (Exception ex){
            log.info("virtual Exception while fetching data:{}",ex.getStackTrace());
        }
        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime) / 1_000_000;
        log.info("virtual Total time taken to fetch the movie data is :{} ms",durationInMillis);
        return movieList;
    }
}
