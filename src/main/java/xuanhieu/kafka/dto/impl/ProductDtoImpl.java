package xuanhieu.kafka.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.dao.ProductsDao;
import xuanhieu.kafka.dto.ProductDto;
import xuanhieu.kafka.entity.Inventory;
import xuanhieu.kafka.entity.Products;

@Service
public class ProductDtoImpl implements ProductDto {

    private static Inventory inventory;
    private static String createdOn;

    @Autowired
    ProductsDao productsDao;
    @Autowired
    InventoryDao inventoryDao;

    @Override
    public Products createNewProduct(Products products) {
        createdOn = products.getCreatedOn();
        inventory = new Inventory(createdOn,createdOn,products.getQuantity(),products.getQuantity(),products.getStatus(),products);
        products.setInventory(inventory);
        return productsDao.createNewProduct(products);
    }

    @Override
    public Products updateProduct(Products products) {
        inventory = inventoryDao.getInventoryByIdProduct(products.getIdProduct());
        inventory .setTotalSales(products.getQuantity());
        inventory.setIdInventory(products.getQuantity());
        inventory.setModifiedOn(products.getModifiedOn());
        inventory.setStatus(products.getStatus());
        inventoryDao.updateInventory(inventory);
        return productsDao.updateProduct(products);
    }

}
