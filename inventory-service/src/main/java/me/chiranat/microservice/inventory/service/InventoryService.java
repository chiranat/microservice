package me.chiranat.microservice.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.chiranat.microservice.inventory.dto.InventoryResponse;
import me.chiranat.microservice.inventory.mapper.InventoryMapper;
import me.chiranat.microservice.inventory.model.Inventory;
import me.chiranat.microservice.inventory.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> getAllInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream()
                .map(inventoryMapper::toResponse)
                .toList();
    }
    
}
