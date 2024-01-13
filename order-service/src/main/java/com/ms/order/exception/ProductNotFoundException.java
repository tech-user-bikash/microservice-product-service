package com.ms.order.exception;

import org.springframework.stereotype.Component;

@Component
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
    public ProductNotFoundException() {
    }
}
