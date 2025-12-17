package com.learning.mongo.model;

import lombok.Data;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "embedded_movies")
@Data
public class EmbeddedMovie {

    @Id
    private ObjectId id;

    private Awards awards;

    private List<String> cast;

    private List<String> countries;

    private List<String> directors;

    private String fullplot;

    private List<String> genres;

    private Imdb imdb;

    private List<String> languages;

    private String lastupdated;

    private Integer metacritic;

    @Field("num_mflix_comments")
    private Integer numMflixComments;

    private String plot;

    /**
     * Vector embeddings (binData)
     */
    @Field("plot_embedding")
    private Binary plotEmbedding;

    @Field("plot_embedding_voyage_3_large")
    private Binary plotEmbeddingVoyage3Large;

    private String poster;

    private String rated;

    private Date released;

    private Integer runtime;

    private String title;

    private Tomatoes tomatoes;

    private String type;

    private List<String> writers;

    /**
     * int | string
     */
    private Object year;
}
