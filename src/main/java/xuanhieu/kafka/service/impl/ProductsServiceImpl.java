package xuanhieu.kafka.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.ProductsDao;
import xuanhieu.kafka.entity.Products;
import xuanhieu.kafka.service.ProductsService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    public static String jsonStringProduct;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date current;
    public static String dateModifiedOnProduct;
    public static final String NAME_CREATE_PRODUCT_TOPIC = "create-product-VXH";
    public static final String NAME_UPDATE_PRODUCT_TOPIC = "update-product-VXH";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    ProductsDao productsDao;

    @Override
    public List<Products> findAllProducts() {
        return productsDao.findAllProducts();
    }

    @Override
    public Products getProductsByIdProduct(Integer id) {
        return productsDao.getProductsByIdProduct(id);
    }

    @Override
    public void createNewProduct(Products products) {
        products.setModifiedOn(products.getCreatedOn());
        try {
            jsonStringProduct = objectMapper.writeValueAsString(products);
            kafkaTemplate.send(NAME_CREATE_PRODUCT_TOPIC, jsonStringProduct);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Products products) {
        current = new Date();
        dateModifiedOnProduct = simpleDateFormat.format(current);
        products.setModifiedOn(dateModifiedOnProduct);
        try {
            jsonStringProduct = objectMapper.writeValueAsString(products);
            kafkaTemplate.send(NAME_UPDATE_PRODUCT_TOPIC, jsonStringProduct);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String deleteProductByIdProduct(Integer id) {
        return productsDao.deleteProductByIdProduct(id);
    }
}
