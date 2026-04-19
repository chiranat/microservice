package me.chiranat.microservice.inventory.mapper;

import org.springframework.stereotype.Component;

import me.chiranat.microservice.inventory.dto.InventoryRequest;
import me.chiranat.microservice.inventory.dto.InventoryResponse;
import me.chiranat.microservice.inventory.model.Inventory;

@Component
public class InventoryMapper {

    public InventoryResponse toResponse(Inventory inventory) {
        return new InventoryResponse(
                inventory.getId(),
                inventory.getSkuCode() != null ? inventory.getSkuCode() : "",
                inventory.getQuantity() != null ? inventory.getQuantity() : 0
        );
    }

    public Inventory toEntity(InventoryRequest inventoryRequest) {
        return new Inventory(
                inventoryRequest.id(),
                inventoryRequest.skuCode(),
                inventoryRequest.quantity()
        );
    }

}
