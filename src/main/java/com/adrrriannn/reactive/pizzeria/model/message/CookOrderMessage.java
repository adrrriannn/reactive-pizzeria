package com.adrrriannn.reactive.pizzeria.model.message;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * Created by adrian on 16/04/2017.
 */
@ToString
public class CookOrderMessage extends AbstractOrderMessage {
    
    @Getter
    private Map<String, Integer> ingredients;
    
    public CookOrderMessage(String orderId, Map<String, Integer> ingredients) {
        super(orderId);
        this.ingredients = ingredients;
    }
    
}
