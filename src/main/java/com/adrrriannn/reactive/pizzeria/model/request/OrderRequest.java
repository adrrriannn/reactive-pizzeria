package com.adrrriannn.reactive.pizzeria.model.request;

import com.adrrriannn.reactive.pizzeria.model.Address;
import com.adrrriannn.reactive.pizzeria.model.Order;
import lombok.Getter;

import java.util.Map;

/**
 * Created by adrian on 16/04/2017.
 */
public class OrderRequest {
    
    public static final String DELIVERY_ADDRESS = "deliveryAddress";
    public static final String INGREDIENTS = "ingredients";
    
    @Getter
    private Address deliveryAddress;
    
    @Getter
    private Map<String, Integer> ingredients;
    
    private OrderRequest() {}
    
    public Order toOrder() {
        return Order.newOrder(this);
    }
    
}
