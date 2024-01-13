package com.ms.inventory.service;

import com.ms.inventory.dto.InventoryRequest;
import com.ms.inventory.dto.InventoryResponse;
import com.ms.inventory.model.Inventory;
import com.ms.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }

    @Transactional
    public Inventory createinventory(InventoryRequest inventoryRequest){
        Inventory inventory = Inventory.builder()
                .skuCode(inventoryRequest.getSkuCode())
                .quantity(inventoryRequest.getQty())
                .build();
        inventoryRepository.save(inventory);
        return inventory;
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}