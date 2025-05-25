package com.sagar.microservices.order.mapper;

import com.sagar.microservices.order.dto.OrderDto;
import com.sagar.microservices.order.model.Order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    /** The singleton instance of the OrderMapper. */
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * Converts a Order entity to a OrderDto.
     *
     * @param order The Order entity to be converted.
     * @return The converted OrderDto.
     */
    OrderDto toDto(Order order);

    /**
     * Converts a Order entity to a Order entity.
     *
     * @param orderDto The Order Dto to be converted.
     * @return The converted order.
     */
    Order toOrder(OrderDto orderDto);
}
