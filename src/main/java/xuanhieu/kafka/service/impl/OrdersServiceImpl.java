package xuanhieu.kafka.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.dao.OrderDetailsDao;
import xuanhieu.kafka.dao.OrdersDao;
import xuanhieu.kafka.entity.OrderDetails;
import xuanhieu.kafka.entity.Orders;
import xuanhieu.kafka.entity.Products;
import xuanhieu.kafka.service.OrdersService;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {


    private static String NAME_CREATE_ORDER_TOPIC = "create-order-VXH";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static String jsonStringOrder;
    private static List<OrderDetails>orderDetailsList;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    OrdersDao ordersDao;

    @Autowired
    InventoryDao inventoryDao;

    @Autowired
    OrderDetailsDao orderDetailsDao;



    private boolean checkProductIntoInventory(List<OrderDetails>orderDetailsList) {
        for (int i = 0; i < orderDetailsList.size(); i++) {
            if (inventoryDao.getInventoryByIdProduct(orderDetailsList.get(i).getProducts().getIdProduct()) == null) {
                return false;
            }
        }
        return true;
    }


    private boolean checkTotalSalesInventory(List<OrderDetails>orderDetailsList) {
        for (int i = 0; i < orderDetailsList.size(); i++) {
            if (inventoryDao.getInventoryByIdProduct(orderDetailsList.get(i).
                    getProducts().getIdProduct()).getTotalSales() <= 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersDao.getAllOrders();
    }

    @Override
    public Orders createNewOrders(Orders orders) {
        orderDetailsList = orders.getOrderDetailsList();
        if ( (checkProductIntoInventory(orderDetailsList)) &&
                (checkTotalSalesInventory(orderDetailsList))
        ) {
            try {
                jsonStringOrder = objectMapper.writeValueAsString(orders);
                kafkaTemplate.send(NAME_CREATE_ORDER_TOPIC, jsonStringOrder);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return orders;
        }
        return null;
    }

    @Override
    public Orders getOrdersById(Integer id) {
        return ordersDao.getOrdersById(id);
    }

    @Override
    public List<OrderDetails> getOrderDetailsByIdOrder(Integer id) {
        return orderDetailsDao.getOrderDetailsByIdOrder(id);
    }
}
