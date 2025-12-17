package com.learning.mongo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "theaters")
@Data
public class Theater {

    @Id
    private ObjectId id;

    private Location location;

    private Integer theaterId;
}
