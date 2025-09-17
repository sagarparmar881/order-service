package com.sagar.microservices.order.mapper;

import com.sagar.microservices.order.dto.RequestOrderDto;
import com.sagar.microservices.order.dto.ResponseOrderDto;
import com.sagar.microservices.order.model.Order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    /** The singleton instance of the OrderMapper. */
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * Converts a Order entity to a ResponseOrderDto.
     *
     * @param order The Order entity to be converted.
     * @return The converted ResponseOrderDto.
     */
    ResponseOrderDto toDto(Order order);

    /**
     * Converts a RequestOrderDto entity to a Order entity.
     *
     * @param requestOrderDto The requestOrderDto Dto to be converted.
     * @return The converted order.
     */
    Order toOrder(RequestOrderDto requestOrderDto);
}
