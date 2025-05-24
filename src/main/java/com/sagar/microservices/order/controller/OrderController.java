package com.sagar.microservices.order.controller;

import com.sagar.microservices.order.dto.OrderRequest;
import com.sagar.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    /**
     * Service layer dependency responsible for order processing logic.
     */
    private final OrderService orderService;

    /**
     * Handles HTTP POST requests to create a new order.
     * Delegates the order placement to the OrderService and
     * returns a success message upon completion.
     *
     * @param orderRequest the details of the order to be placed
     * @return a confirmation indicating the order was placed successfully
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody final OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully.";
    }
}
