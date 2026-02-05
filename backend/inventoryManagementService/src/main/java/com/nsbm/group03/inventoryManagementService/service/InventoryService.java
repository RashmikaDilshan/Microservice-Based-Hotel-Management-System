package com.nsbm.group03.inventoryManagementService.service;

import com.nsbm.group03.inventoryManagementService.entity.InventoryItem;
import com.nsbm.group03.inventoryManagementService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired

    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getAllItem(){
        return inventoryRepository.findAll();
    }

    public InventoryItem addItem(InventoryItem item){
        return inventoryRepository.save(item);
    }

    public InventoryItem updateStock(Long id, int amountUsed){
        InventoryItem item = inventoryRepository.findById(id).orElseThrow();
        int newQuantity = item.getQuantity() - amountUsed;
        if (newQuantity < 0){
            throw new RuntimeException("Not enough stock");
        }
        item.setQuantity(newQuantity);
        return inventoryRepository.save(item);
    }

}
