package com.sagar.microservices.order.service;

import com.sagar.microservices.order.client.InventoryClient;
import com.sagar.microservices.order.dto.RequestOrderDto;
import com.sagar.microservices.order.dto.ResponseOrderDto;
import com.sagar.microservices.order.exception.OrderServiceException;
import com.sagar.microservices.order.mapper.OrderMapper;
import com.sagar.microservices.order.model.Order;
import com.sagar.microservices.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    private final OrderMapper orderMapper;

    @Transactional
    public ResponseOrderDto placeOrder(final RequestOrderDto requestOrderDto) {

        var inventoryResponse =
                this.inventoryClient.isInStock(requestOrderDto.skuCode(), requestOrderDto.quantity());

        if (inventoryResponse.getCode() == 3000) {
            var order = this.orderMapper.toOrder(requestOrderDto);
            order.setOrderNumber("order-" + UUID.randomUUID());
            this.orderRepository.save(order);
            return this.orderMapper.toDto(order);
        } else {
            throw new OrderServiceException(inventoryResponse.getMessage());
        }
    }

    public Page<ResponseOrderDto> getAllOrders(final int page, final int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Order> productPage = this.orderRepository.findAll(pageable);
        return productPage.map(orderMapper::toDto);
    }
}
