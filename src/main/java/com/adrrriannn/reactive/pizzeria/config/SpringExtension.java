package com.adrrriannn.reactive.pizzeria.config;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;
import com.adrrriannn.reactive.pizzeria.actor.Listener;
import org.springframework.context.ApplicationContext;

/**
 * Created by adrian on 16/04/2017.
 */
public class SpringExtension extends AbstractExtensionId {

    public static SpringExtension SPRING_EXTENSION_PROVIDER = new SpringExtension();
    
    @Override
    public SpringExt createExtension (ExtendedActorSystem extendedActorSystem) {
        return new SpringExt();
    }

    public static class SpringExt implements Extension {

        private volatile ApplicationContext applicationContext;

        public void initialize (ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        public Props props (String actorBeanName) {
            return Props.create(Listener.class, applicationContext, actorBeanName);
        }

    }
}    
