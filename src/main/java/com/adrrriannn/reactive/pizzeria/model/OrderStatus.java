package com.adrrriannn.reactive.pizzeria.model;

import lombok.Getter;

/**
 * Created by adrian on 16/04/2017.
 */
public class OrderStatus {
    
    public enum Status {
        
        QUEUE, COOKING, READY_FOR_DELIVERY, DELIVERING, DELIVERED, ERROR
    }
    
    @Getter
    private Status status;
    
    @Getter
    private long created;
    
    @Getter
    private String errorMessage;
    
    private OrderStatus(Status status) {
        this.created = System.currentTimeMillis();
        this.status = status;
    }
    
    private OrderStatus(Status status, String errorMessage) {
        this(status);
        this.errorMessage = errorMessage;
    }
    
    
    public static OrderStatus success(Status status) {
        return new OrderStatus(status);
    }
    
    public static OrderStatus failed(String errorMessage) {
        return new OrderStatus(Status.ERROR, errorMessage);
    }
}
