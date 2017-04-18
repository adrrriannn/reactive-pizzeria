package com.adrrriannn.reactive.pizzeria.model.message;

import com.adrrriannn.reactive.pizzeria.model.Address;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by adrian on 16/04/2017.
 */
@ToString
public class DeliveryOrderMessage extends AbstractOrderMessage {
    
    @Getter
    private Address deliveryAddress;
    
    public DeliveryOrderMessage(String orderId, Address deliveryAddress) {
        super(orderId);
        this.deliveryAddress = deliveryAddress;
    }
    
}
