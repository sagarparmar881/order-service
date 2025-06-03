package com.sagar.microservices.order.exception;

import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorCode;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@ResponseErrorCode("PRODUCT_SERVICE_EXCEPTION")
public class OrderServiceException extends RuntimeException {
    /**
     * The timestamp indicating when the error occurred.
     */
    @ResponseErrorProperty
    private final LocalDateTime timestamp = LocalDateTime.now();

    /**
     * Exception thrown for generic errors in the Product Service.
     *
     * @param message the detail message explaining the cause of the exception
     */
    public OrderServiceException(final String message) {
        super(message);
    }
}