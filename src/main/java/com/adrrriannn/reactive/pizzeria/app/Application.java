package com.adrrriannn.reactive.pizzeria.app;

import akka.actor.ActorSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by adrian on 14/04/2017.
 */
@SpringBootApplication
public class Application {
    
    public void main(String[] args) {
        SpringApplication.run(this.getClass(), args);
    }
    
    @Bean
    public ActorSystem actorSystem() {
        
        return null;
    }
}
