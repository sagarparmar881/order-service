package com.sagar.microservices.order.enums;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    ORDER_CREATED(1000,"Order placed successfully", HttpStatus.CREATED),
    ORDER_RETRIEVED(1001,"Order details retrieved successfully", HttpStatus.OK);

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
}