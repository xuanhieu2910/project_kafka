package xuanhieu.kafka.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.dto.InventoryDto;
import xuanhieu.kafka.entity.Inventory;

@Service
public class InventoryDtoImpl implements InventoryDto {

    @Autowired
    InventoryDao inventoryDao;

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryDao.updateInventory(inventory);
    }
}
