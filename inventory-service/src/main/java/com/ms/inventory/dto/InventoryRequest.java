package com.ms.inventory.dto;

import lombok.Data;

@Data
public class InventoryRequest {
    private String skuCode;
    private int qty;
}
