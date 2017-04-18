package com.adrrriannn.reactive.pizzeria.actor;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import com.adrrriannn.reactive.pizzeria.model.OrderStatus;

/**
 * Created by adrian on 16/04/2017.
 */
public abstract class AbstractWorker<T> extends AbstractActor {
    
    abstract OrderStatus doSpecificWork(T orderMessage) throws Exception;
    abstract Class<T> getMessageClass();

    @Override
    public Receive createReceive () {

        return ReceiveBuilder.create()
            .match(getMessageClass(), message -> doWork(message))
            .build();
    }
    
    public OrderStatus doWork(T orderMessage) {
        
        OrderStatus orderStatus;
        try {
            orderStatus = doSpecificWork(orderMessage);
        } catch (Exception ex) {
            orderStatus = OrderStatus.failed(ex.getMessage());
        }
        
        return orderStatus;
    }
}
