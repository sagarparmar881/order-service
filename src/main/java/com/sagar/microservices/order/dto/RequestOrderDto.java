package com.sagar.microservices.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;

public record RequestOrderDto(
        @JsonProperty("order_number") @Null String orderNumber,
        @JsonProperty("sku_code") String skuCode,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("quantity") Integer quantity
) { }
