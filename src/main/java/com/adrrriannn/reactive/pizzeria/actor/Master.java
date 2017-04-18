package com.adrrriannn.reactive.pizzeria.actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import com.adrrriannn.reactive.pizzeria.model.message.CookOrderMessage;
import com.adrrriannn.reactive.pizzeria.model.message.DeliveryOrderMessage;
import com.adrrriannn.reactive.pizzeria.response.WorkerResponse;

/**
 * Created by adrian on 16/04/2017.
 */
public class Master extends AbstractActor {
    
    private ActorRef listener;
    private ActorRef chefRouter;
    private ActorRef deliveryRouter;
    
    public Master(ActorRef listener) {
        this.listener = listener;
        chefRouter = getContext()
            .actorOf(Props.create(Chef.class).withRouter(new RoundRobinPool(Chef.NUMBER_OF_CHEFS)));
        deliveryRouter = getContext()
            .actorOf(Props.create(DeliveryPerson.class).withRouter(new RoundRobinPool(DeliveryPerson.NUMBER_OF_DELIVERY_PEOPLE))); 
    }

    @Override
    public Receive createReceive () {
        return ReceiveBuilder.create()
            .match(
                CookOrderMessage.class, cookOrderMessage -> chefRouter.tell(cookOrderMessage, getSelf())
            )
            .match(
                DeliveryOrderMessage.class, deliveryOrderMessage -> deliveryRouter.tell(deliveryOrderMessage, getSelf())
            )
            .match(WorkerResponse.class, workerResponse -> listener.tell(workerResponse, getSelf()))
            .build();
    }
}
