package xuanhieu.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.kafka.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
