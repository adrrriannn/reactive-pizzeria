package com.adrrriannn.reactive.pizzeria.actor;

import com.adrrriannn.reactive.pizzeria.model.OrderStatus;
import com.adrrriannn.reactive.pizzeria.model.message.CookOrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by adrian on 14/04/2017.
 */
public class Chef extends AbstractWorker<CookOrderMessage> {
    
    public static final int NUMBER_OF_CHEFS = 3; 
    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Override
    OrderStatus doSpecificWork (CookOrderMessage cookOrderMessage) throws Exception {

        log.info("Cooking order {}", cookOrderMessage);

        OrderStatus orderStatus;

        try {
            Thread.sleep(10000);
            orderStatus = OrderStatus.success(OrderStatus.Status.READY_FOR_DELIVERY);
        } catch (Exception ex) {
            orderStatus = OrderStatus.failed(ex.getMessage());
        }
        
        return orderStatus;
    }

    @Override
    Class<CookOrderMessage> getMessageClass () {
        return CookOrderMessage.class;
    }
}
