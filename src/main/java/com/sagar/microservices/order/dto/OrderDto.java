package com.sagar.microservices.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;

public record OrderDto(
        @JsonProperty("id") @Null Long id,
        @JsonProperty("order_number") String orderNumber,
        @JsonProperty("sku_code") String skuCode,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("quantity") Integer quantity
) { }
