package com.adrrriannn.reactive.pizzeria.service;

import com.adrrriannn.reactive.pizzeria.model.Order;
import com.adrrriannn.reactive.pizzeria.model.OrderStatus;
import com.adrrriannn.reactive.pizzeria.model.request.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by adrian on 14/04/2017.
 */
@Service
public class PizzeriaService {
    
    private static ConcurrentHashMap<Integer, OrderStatus> orderStatuses = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer,Order> orders = new ConcurrentHashMap<>();
    
    public void updateOrderStatus(Integer orderId, OrderStatus orderStatus) {
        
        orderStatuses.put(orderId, orderStatus);
    }
    
    private OrderStatus getOrderStatus(String orderId) {
        return orderStatuses.get(orderId);
    }
    
    public Order insertOrder(OrderRequest orderRequest) {
        Order order = orderRequest.toOrder();
        
        Integer orderId = order.getId();
        orders.put(orderId, order);
        
        orderStatuses.put(orderId, OrderStatus.success(OrderStatus.Status.QUEUE));
        
        return order;
    }
    
    public Order getOrder(Integer orderId) {
        
        Order order = orders.get(orderId);
        OrderStatus orderStatus = orderStatuses.get(orderId);
        
        return new Order(order, orderStatus);
    }
    
}
