package com.learning.mongo.repository;

import com.learning.mongo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {

    @Query(fields = "{'title': 1,'year': 1}")
    public List<Movie> findAllByTitle(String title);

    @Query(value = "{}", fields = "{'title': 1,'genres': 1,'plot': 1,'_id': 1}")
    public List<Movie> getAllMovies();


}
