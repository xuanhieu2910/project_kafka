package xuanhieu.kafka.dao;

import xuanhieu.kafka.entity.Inventory;

import java.util.List;

public interface InventoryDao {

    List<Inventory> findAllInventory();

    Inventory createInventory(Inventory inventory);

    Inventory getInventoryById(Integer id);

    Inventory updateInventory(Inventory inventory);

    String deleteInventoryById(Integer id);

    Inventory getInventoryByIdProduct(Integer idProduct);
}
