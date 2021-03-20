package xuanhieu.kafka.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.dao.ProductsDao;
import xuanhieu.kafka.entity.Inventory;
import xuanhieu.kafka.entity.Products;
import xuanhieu.kafka.service.InventoryService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final String NAME_UPDATE_INVENTORY_TOPIC = "update-inventory-VXH";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static String jsonStringInventory;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Date current;
    private static String modifiedOn;
    private static Products products;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    InventoryDao inventoryDao;

    @Autowired
    ProductsDao productsDao;


    @Override
    public List<Inventory> findAllInventory() {
        return inventoryDao.findAllInventory();
    }


    @Override
    public Inventory getInventoryById(Integer id) {
        return inventoryDao.getInventoryById(id);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        current = new Date();
        modifiedOn = simpleDateFormat.format(current);
        inventory.setModifiedOn(modifiedOn);
        try {
            jsonStringInventory = objectMapper.writeValueAsString(inventory);
            kafkaTemplate.send(NAME_UPDATE_INVENTORY_TOPIC, jsonStringInventory);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String deleteInventoryById(Integer id) {
        products = inventoryDao.getInventoryById(id).getProducts();
        productsDao.deleteProductByIdProduct(products.getIdProduct());
        return inventoryDao.deleteInventoryById(id);
    }
}
