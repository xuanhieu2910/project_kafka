package xuanhieu.kafka.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.entity.Inventory;
import xuanhieu.kafka.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> findAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryById(Integer id) {
        Optional<Inventory>inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()){
            return inventory.get();
        }
        return null;
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public String deleteInventoryById(Integer id) {
        Optional<Inventory>inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()){
            inventoryRepository.deleteById(id);
            return "Xóa thành công!";
        }
        return null;
    }

    @Override
    public Inventory getInventoryByIdProduct(Integer idProduct) {
        return inventoryRepository.getInventoriesByIdProduct(idProduct);
    }
}
