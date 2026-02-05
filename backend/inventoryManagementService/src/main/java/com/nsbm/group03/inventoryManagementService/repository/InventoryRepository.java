package com.nsbm.group03.inventoryManagementService.repository;

import com.nsbm.group03.inventoryManagementService.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findByCategory(String category);
}
