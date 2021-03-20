package xuanhieu.kafka.service;

import xuanhieu.kafka.entity.Inventory;

import java.util.*;

public interface InventoryService {

    List<Inventory> findAllInventory();

    Inventory getInventoryById(Integer id);

    void updateInventory(Inventory inventory);

    String deleteInventoryById(Integer id);

}
