package com.sagar.microservices.order.dto;

import lombok.Getter;

@Getter
public class InventoryResponse {

    private int code;
    private String message;
    private String body;
}
