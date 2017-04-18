package com.adrrriannn.reactive.pizzeria.response;

import com.adrrriannn.reactive.pizzeria.model.OrderStatus;
import lombok.Getter;

/**
 * Created by adrian on 16/04/2017.
 */
public class WorkerResponse {
    
    @Getter
    private Integer orderId;
    
    @Getter
    private OrderStatus orderStatus;
    
    public WorkerResponse(Integer orderId, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
}
