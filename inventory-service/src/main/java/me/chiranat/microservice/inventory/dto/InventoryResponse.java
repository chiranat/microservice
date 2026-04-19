package me.chiranat.microservice.inventory.dto;

public record InventoryResponse(Long id, String skuCode, Integer quantity) {
    
}
