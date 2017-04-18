package com.adrrriannn.reactive.pizzeria.actor;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import com.adrrriannn.reactive.pizzeria.response.WorkerResponse;
import com.adrrriannn.reactive.pizzeria.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by adrian on 16/04/2017.
 */
public class Listener extends AbstractActor {
    
    @Autowired
    PizzeriaService pizzeriaService;
    
    @Override
    public Receive createReceive () {
        return ReceiveBuilder.create()
            .match(WorkerResponse.class, workerResponse -> updateOrderStatus(workerResponse))
            .build();
    }
    
    private void updateOrderStatus(WorkerResponse workerResponse) {
        
        pizzeriaService.updateOrderStatus(workerResponse.getOrderId(), workerResponse.getOrderStatus());
    }
    
}
