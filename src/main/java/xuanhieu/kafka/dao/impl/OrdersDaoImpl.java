package xuanhieu.kafka.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.kafka.dao.OrdersDao;
import xuanhieu.kafka.entity.Orders;
import xuanhieu.kafka.repository.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders createNewOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrdersById(Integer id) {
        Optional<Orders>orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            return orders.get();
        }
        return null;
    }
}
