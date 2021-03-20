package xuanhieu.kafka.dto;

import xuanhieu.kafka.entity.Products;

public interface ProductDto {

    Products createNewProduct(Products products);

    Products updateProduct(Products products);
}
