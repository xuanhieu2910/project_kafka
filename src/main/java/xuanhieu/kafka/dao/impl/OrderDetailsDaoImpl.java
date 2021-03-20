package xuanhieu.kafka.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.kafka.dao.OrderDetailsDao;
import xuanhieu.kafka.entity.OrderDetails;
import xuanhieu.kafka.repository.OrderDetailsRepository;

import java.util.List;

@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getOrderDetailsByIdOrder(Integer id) {
        return orderDetailsRepository.getOrderDetailsByIdOrders(id);
    }
}
