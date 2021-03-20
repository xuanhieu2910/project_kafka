package xuanhieu.kafka.dao;
import xuanhieu.kafka.entity.OrderDetails;

import java.util.*;
public interface OrderDetailsDao {

    List<OrderDetails> getOrderDetailsByIdOrder(Integer id);
}
