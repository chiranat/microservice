package me.chiranat.microservice.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.chiranat.microservice.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
