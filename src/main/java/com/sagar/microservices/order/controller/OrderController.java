package com.sagar.microservices.order.controller;

import com.sagar.microservices.order.dto.RequestOrderDto;
import com.sagar.microservices.order.enums.ResponseCode;
import com.sagar.microservices.order.response.ApiResponse;
import com.sagar.microservices.order.response.OrderServiceResponse;
import com.sagar.microservices.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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
     * @param requestOrderDto the details of the order to be placed
     * @return a confirmation indicating the order was placed successfully
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> createOrder(
            @RequestBody final RequestOrderDto requestOrderDto) {

        var placedOrderDto = orderService.placeOrder(requestOrderDto);
        return OrderServiceResponse.build(
                ResponseCode.ORDER_CREATED, placedOrderDto);
    }

    /**
     * Retrieves all orders.
     * @param page the page number for pagination
     * @param size the size of elements on page
     * @return a list of all orders
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get all orders",
            description = "This endpoint retrieves all orders."
    )
    public ResponseEntity<ApiResponse> getAllOrders(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size) {

        var allOrdersDto = orderService.getAllOrders(page, size);
        return OrderServiceResponse.build(
                ResponseCode.ORDER_RETRIEVED, allOrdersDto);
    }
}
