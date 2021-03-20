package xuanhieu.kafka.service;

import xuanhieu.kafka.entity.Products;

import java.util.List;

public interface ProductsService {
    List<Products> findAllProducts();
    Products getProductsByIdProduct(Integer id);
    void createNewProduct(Products products);
    void updateProduct(Products products);
    String deleteProductByIdProduct(Integer id);
}
