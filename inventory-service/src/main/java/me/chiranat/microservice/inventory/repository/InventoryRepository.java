package me.chiranat.microservice.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.chiranat.microservice.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
