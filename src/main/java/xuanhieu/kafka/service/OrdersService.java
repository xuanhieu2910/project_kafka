package xuanhieu.kafka.service;
import xuanhieu.kafka.entity.OrderDetails;
import xuanhieu.kafka.entity.Orders;

import java.util.*;
public interface OrdersService {

    List<Orders>getAllOrders();

    Orders createNewOrders(Orders orders);

    Orders getOrdersById(Integer id);

    List<OrderDetails>getOrderDetailsByIdOrder(Integer id);
}
