package me.chiranat.microservice.order.Mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import me.chiranat.microservice.order.dto.OrderRequest;
import me.chiranat.microservice.order.dto.OrderResponse;
import me.chiranat.microservice.order.model.Order;

@Component
public class OrderMapper {
    public Order toEntity(OrderRequest orderRequest) {
        return new Order(
            null,
            UUID.randomUUID().toString(),
            orderRequest.skuCode(),
            orderRequest.price(),
            orderRequest.quantity()
        );
    }

    public OrderResponse toResponse(Order order) {
        return new OrderResponse(
            order.getId(),
            order.getOrderNumber(),
            order.getSkuCode(),
            order.getPrice(),
            order.getQuantity()
        );
    }
}
