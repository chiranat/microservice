package me.chiranat.microservice.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.chiranat.microservice.order.dto.OrderRequest;
import me.chiranat.microservice.order.dto.OrderResponse;
import me.chiranat.microservice.order.service.Orderservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final Orderservice orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }
    

}
