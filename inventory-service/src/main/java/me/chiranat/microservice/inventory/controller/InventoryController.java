package me.chiranat.microservice.inventory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.chiranat.microservice.inventory.dto.InventoryResponse;
import me.chiranat.microservice.inventory.service.InventoryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> getAllInventories() {
        return inventoryService.getAllInventories();
    }
    
}
