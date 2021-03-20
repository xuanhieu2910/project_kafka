package xuanhieu.kafka.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.kafka.dao.ProductsDao;
import xuanhieu.kafka.entity.Products;
import xuanhieu.kafka.repository.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsDaoImpl implements ProductsDao {



    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProductsByIdProduct(Integer id) {
        Optional<Products>products = productsRepository.findById(id);
        if(products.isPresent()){
            return products.get();
        }
        return null;
    }

    @Override
    public Products createNewProduct(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products updateProduct(Products products) {
        Optional<Products>products1 = productsRepository.findById(products.getIdProduct());
        if(products1.isPresent()){
            return productsRepository.save(products);
        }
        return null;
    }

    @Override
    public String deleteProductByIdProduct(Integer id) {
        Optional<Products>products = productsRepository.findById(id);
        if(products.isPresent()){
            productsRepository.deleteById(id);
            return "Xóa thành công!";
        }
        return null;
    }
}
