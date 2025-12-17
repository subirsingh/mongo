package com.learning.mongo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "comments")
@Data
public class Comment {

    @Id
    private ObjectId id;

    private Date date;

    private String email;

    @Field("movie_id")
    private ObjectId movieId;

    private String name;

    private String text;
}
