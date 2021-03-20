package xuanhieu.kafka.listener;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dto.ProductDto;
import xuanhieu.kafka.entity.Products;

@Service
public class ListenerConsumerProduct {

    private static final Gson gson = new Gson();
    private static Products products;

    @Autowired
    ProductDto productDto;


    @KafkaListener(topics = "create-product-VXH", groupId = "group-id")
    public void createProduct(String jsonStringProduct) {
        products = gson.fromJson(jsonStringProduct, Products.class);
        productDto.createNewProduct(products);
        return;
    }

    @KafkaListener(topics = "update-product-VXH", groupId = "group-id")
    public void updateProduct(String jsonStringProduct) {
        products = gson.fromJson(jsonStringProduct, Products.class);
        productDto.updateProduct(products);
        return;
    }


}
