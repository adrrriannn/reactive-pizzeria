package com.adrrriannn.reactive.pizzeria.model;

import com.adrrriannn.reactive.pizzeria.model.request.OrderRequest;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by adrian on 14/04/2017.
 */
@ToString
public class Order {
    
    private static AtomicInteger ordersCreated = new AtomicInteger(0);
    
    private Order() {}
    
    @Getter
    private Integer id;
    
    @Getter
    private Address deliveryAddress;
    
    @Getter
    private Map<String, Integer> ingredients;
    
    @Getter
    OrderStatus orderStatus;
    
    private Order(Integer id, Address deliveryAddress, Map<String, Integer> ingredients) {
        this.id = id;
        this.deliveryAddress = deliveryAddress;
        this.ingredients = ingredients;
    }

    public Order(Order order, OrderStatus orderStatus) {
        this(order.getId(), order.getDeliveryAddress(), order.getIngredients());
        this.orderStatus = orderStatus;
    }
    
    public static Order newOrder(OrderRequest orderRequest) {
        Integer id = ordersCreated.incrementAndGet();
        return new Order(id, orderRequest.getDeliveryAddress(), orderRequest.getIngredients());
    }
}
