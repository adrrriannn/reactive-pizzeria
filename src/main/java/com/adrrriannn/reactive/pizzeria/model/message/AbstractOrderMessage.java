package com.adrrriannn.reactive.pizzeria.model.message;

import lombok.Getter;

/**
 * Created by adrian on 16/04/2017.
 */
public abstract class AbstractOrderMessage {
    
    @Getter
    private String orderId;
    
    public AbstractOrderMessage(String orderId) {
        this.orderId = orderId;
    }
    
}
