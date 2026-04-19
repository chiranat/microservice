package me.chiranat.microservice.order.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface InventoryClient {
    
    @GetExchange("/api/inventory")
    boolean isInstock(@RequestParam String skuCode, @RequestParam int quantity);

}
