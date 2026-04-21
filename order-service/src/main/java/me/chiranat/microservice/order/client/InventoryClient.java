package me.chiranat.microservice.order.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import groovy.util.logging.Slf4j;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Slf4j
public interface InventoryClient {
    
    Logger log = LoggerFactory.getLogger(InventoryClient.class);

    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInstock(@RequestParam String skuCode, @RequestParam int quantity);

    default boolean fallbackMethod(String code, int quantity, Throwable throwable){
        log.info("Cannot get inventory for skuCode {}, failure reason: {}", code, throwable.getMessage());
        return false;
    }

}
