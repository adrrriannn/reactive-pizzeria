package com.adrrriannn.reactive.pizzeria.controller;

import com.adrrriannn.reactive.pizzeria.model.Order;
import com.adrrriannn.reactive.pizzeria.model.request.OrderRequest;
import com.adrrriannn.reactive.pizzeria.service.PizzeriaService;
import com.adrrriannn.reactive.pizzeria.validator.OrderRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by adrian on 14/04/2017.
 */
@RestController
@RequestMapping("/order")
public class PizzeriaController {
    
    PizzeriaService pizzeriaService;
    OrderRequestValidator orderRequestValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(orderRequestValidator);
    }
    
    @Autowired
    public PizzeriaController(PizzeriaService pizzeriaService,
                              OrderRequestValidator orderRequestValidator) {
        this.pizzeriaService = pizzeriaService;
        this.orderRequestValidator = orderRequestValidator;
    }
    
    @PostMapping
    public Order placeOrder(@Valid @RequestBody OrderRequest orderRequest) {
        
        return pizzeriaService.insertOrder(orderRequest);
    }
    
    @GetMapping("/{order-id}")
    public Order getOrder(@PathVariable("order-id") Integer orderId) {
        
        return pizzeriaService.getOrder(orderId);
    }
}
