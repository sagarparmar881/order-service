package com.sagar.microservices.order.service;

import com.sagar.microservices.order.dto.OrderRequest;
import com.sagar.microservices.order.model.Order;
import com.sagar.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){

        Order order = new Order();
        order.setOrderId(orderRequest.id());
        order.setOrderNumber(orderRequest.orderNumber());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }
}
