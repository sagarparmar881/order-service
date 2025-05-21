package com.sagar.microservices.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record OrderRequest(
        @JsonProperty("order_number") String orderNumber,
        @JsonProperty("sku_code") String skuCode,
        @JsonProperty("price") BigDecimal price,
        @JsonProperty("quantity") Integer quantity
) { }