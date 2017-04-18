package com.adrrriannn.reactive.pizzeria.actor;

import com.adrrriannn.reactive.pizzeria.model.OrderStatus;
import com.adrrriannn.reactive.pizzeria.model.message.DeliveryOrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by adrian on 14/04/2017.
 */
public class DeliveryPerson extends AbstractWorker<DeliveryOrderMessage> {
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    public static final int NUMBER_OF_DELIVERY_PEOPLE = 4;
    
    @Override
    OrderStatus doSpecificWork (DeliveryOrderMessage orderMessage) throws Exception {
        
        log.info("Delivery order: {}", orderMessage);
        
        OrderStatus orderStatus;
        try {
            Thread.sleep(10000);
            orderStatus = OrderStatus.success(OrderStatus.Status.DELIVERED);
        } catch (Exception ex) {
            orderStatus = OrderStatus.failed(ex.getMessage());
        }

        return orderStatus;
    }

    @Override
    Class<DeliveryOrderMessage> getMessageClass () {
        return DeliveryOrderMessage.class;
    }
}
