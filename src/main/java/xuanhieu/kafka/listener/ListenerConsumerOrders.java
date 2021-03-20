package xuanhieu.kafka.listener;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.dto.OrderDto;
import xuanhieu.kafka.entity.OrderDetails;
import xuanhieu.kafka.entity.Orders;

import java.util.*;

@Service
public class ListenerConsumerOrders {

    private static final Gson gson = new Gson();
    private static Orders orders;

    @Autowired
    OrderDto orderDto;


    @KafkaListener(topics = "create-order-VXH", groupId = "group-id")
    public String createOrder(String jsonStringOrder) {
        orders = gson.fromJson(jsonStringOrder, Orders.class);
        orderDto.createOrders(orders);
        return "";
    }
}
