package com.learning.mongo.model;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;

    private String email;

    private String name;

    private String password;

    /**
     * Schema allows an open object (no defined properties).
     * Keep it flexible.
     */
    private Preferences preferences;
}
