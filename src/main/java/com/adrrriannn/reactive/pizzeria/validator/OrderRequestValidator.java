package com.adrrriannn.reactive.pizzeria.validator;

import com.adrrriannn.reactive.pizzeria.model.Address;
import com.adrrriannn.reactive.pizzeria.model.request.OrderRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by adrian on 16/04/2017.
 */
public class OrderRequestValidator implements Validator {
    
    @Override
    public boolean supports (Class<?> clazz) {
        return OrderRequest.class.equals(clazz);
    }

    @Override
    public void validate (Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, OrderRequest.DELIVERY_ADDRESS, "Delivery address cannot be empty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(
            errors, OrderRequest.DELIVERY_ADDRESS + "." + Address.FIRST_ADDRESS_LINE, "First line of address cannot be empty"
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
            errors, OrderRequest.DELIVERY_ADDRESS + "." + Address.RECIPIENT, "Address recipient cannot be empty"
        );
        
        ValidationUtils.rejectIfEmptyOrWhitespace(
            errors, OrderRequest.DELIVERY_ADDRESS + "." + Address.CITY, "City cannot be empty"
        );
        
        ValidationUtils.rejectIfEmptyOrWhitespace(
            errors, OrderRequest.DELIVERY_ADDRESS + "." + Address.POSTCODE, "City cannot be empty"
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(
            errors, OrderRequest.DELIVERY_ADDRESS + "." + Address.COUNTRY, "City cannot be empty"
        );
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, OrderRequest.INGREDIENTS, "Ingredientes cannot be empty");
    }
}
