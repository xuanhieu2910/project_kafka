package xuanhieu.kafka.dao;
import xuanhieu.kafka.entity.Products;

import java.util.*;
public interface ProductsDao {


    List<Products>findAllProducts();

    Products getProductsByIdProduct(Integer id);

    Products createNewProduct(Products products);

    Products updateProduct(Products products);

    String deleteProductByIdProduct(Integer id);


}
