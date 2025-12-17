package com.learning.mongo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Tomatoes {
    private String boxOffice;
    private String consensus;
    private Critic critic;
    private Date dvd;
    private Integer fresh;
    private Date lastUpdated;
    private String production;
    private Integer rotten;
    private Viewer viewer;
    private String website;
}
