package com.adrrriannn.reactive.pizzeria.model;

import lombok.Getter;

/**
 * Created by adrian on 14/04/2017.
 */
public class Address {
    
    public static final String RECIPIENT = "recipient";
    public static final String FIRST_ADDRESS_LINE = "firstAddressLine";
    public static final String SECOND_ADDRESS_LINE = "secondAddressLine";
    public static final String THIRD_ADDRESS_LINE = "thirdAddressLine";
    public static final String POSTCODE = "postcode";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    
    @Getter
    private String recipient;
    
    @Getter
    private String firstAddressLine;
    
    @Getter
    private String secondAddressLine;
    
    @Getter
    private String thirdAddressLine;
    
    @Getter
    private String postcode;
    
    @Getter
    private String city;
    
    @Getter
    private String country;
    
    private Address() {}
}
