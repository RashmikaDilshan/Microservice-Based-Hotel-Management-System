package com.nsbm.group03.inventoryManagementService.controller;

import com.nsbm.group03.inventoryManagementService.entity.InventoryItem;
import com.nsbm.group03.inventoryManagementService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryItem> getInventory(){
        return inventoryService.getAllItem();
    }

    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem item){
        return inventoryService.addItem(item);
    }

    @PutMapping("/{id}/consume")
    public InventoryItem consumeItem(@PathVariable Long id, @RequestParam int amountUsed){
        return inventoryService.updateStock(id, amountUsed);
    }



}
