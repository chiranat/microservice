package me.chiranat.microservice.order.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.chiranat.microservice.order.Mapper.OrderMapper;
import me.chiranat.microservice.order.client.InventoryClient;
import me.chiranat.microservice.order.dto.OrderRequest;
import me.chiranat.microservice.order.dto.OrderResponse;
import me.chiranat.microservice.order.model.Order;
import me.chiranat.microservice.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class Orderservice {
    
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInstock(orderRequest.skuCode(), orderRequest.quantity());

        if (!isProductInStock) {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
        }

        Order order = orderMapper.toEntity(orderRequest);
        if (order == null) {
            throw new IllegalArgumentException("Failed to map OrderRequest to Order entity");
        }
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }

}
