package com.learning.mongo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sessions")
@Data
public class Session {

    @Id
    private ObjectId id;

    private String jwt;

    /**
     * Stored as string in schema
     */
    @Field("user_id")
    private String userId;
}
