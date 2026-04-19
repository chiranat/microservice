package me.chiranat.microservice.inventory.dto;

public record InventoryRequest(Long id, String skuCode, Integer quantity) {
    
}
