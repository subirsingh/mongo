package com.learning.mongo.model;

import lombok.Data;

@Data
public class Awards {
    private Integer nominations;
    private String text;
    private Integer wins;
}
