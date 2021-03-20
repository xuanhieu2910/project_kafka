package xuanhieu.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xuanhieu.kafka.entity.OrderDetails;
import java.util.*;
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {


    @Query("SELECT od FROM OrderDetails od WHERE od.orders.idOrders=:id")
    List<OrderDetails>getOrderDetailsByIdOrders(Integer id);
}
