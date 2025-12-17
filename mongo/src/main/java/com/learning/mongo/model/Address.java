package com.learning.mongo.model;

import lombok.Data;

@Data
public class Address {
    private String city;

    private String state;

    private String street1;

    /**
     * Nullable field (string | null)
     */
    private String street2;

    private String zipcode;
}
