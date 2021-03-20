package xuanhieu.kafka.dao;
import xuanhieu.kafka.entity.Orders;

import java.util.*;
public interface OrdersDao {

    List<Orders>getAllOrders();

    Orders createNewOrders(Orders orders);

    Orders getOrdersById(Integer id);
}
