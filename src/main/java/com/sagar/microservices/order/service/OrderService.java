package com.sagar.microservices.order.service;

import com.sagar.microservices.order.client.InventoryClient;
import com.sagar.microservices.order.dto.OrderDto;
import com.sagar.microservices.order.mapper.OrderMapper;
import com.sagar.microservices.order.model.Order;
import com.sagar.microservices.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    private final OrderMapper orderMapper;

    @Transactional
    public OrderDto placeOrder(final OrderDto orderDto) {

        var inventoryResponse =
                this.inventoryClient.isInStock(orderDto.skuCode(), orderDto.quantity());

        if (inventoryResponse.getCode() == 3000) {
            var order = this.orderMapper.toOrder(orderDto);
            this.orderRepository.save(order);
            return this.orderMapper.toDto(order);
        } else {
            throw new RuntimeException("Product is not in stock");
        }
    }

    public Page<OrderDto> getAllOrders(final int page, final int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Order> productPage = this.orderRepository.findAll(pageable);
        return productPage.map(orderMapper::toDto);
    }
}
