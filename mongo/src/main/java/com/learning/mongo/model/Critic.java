package com.learning.mongo.model;

import lombok.Data;

@Data
public class Critic {
    private Integer meter;
    private Integer numReviews;
    private Double rating;
}
