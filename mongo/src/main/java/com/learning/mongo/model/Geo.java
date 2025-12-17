package com.learning.mongo.model;

import lombok.Data;

import java.util.List;

@Data
public class Geo {
    /**
     * [longitude, latitude]
     */
    private List<Double> coordinates;

    /**
     * Usually "Point"
     */
    private String type;
}
