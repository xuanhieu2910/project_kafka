package xuanhieu.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.kafka.entity.OrderDetails;
import xuanhieu.kafka.entity.Orders;
import xuanhieu.kafka.service.OrdersService;

import java.util.*;
@RestController
@RequestMapping(name = "/kafka")
public class OrdersController {

    @Autowired
    OrdersService ordersService;


    @GetMapping(value = "/orders")
    public List<Orders>findAllOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping(value = "/order/{id}")
    public List<OrderDetails>getOrderDetailsByID(@PathVariable("id")Integer id){
        return ordersService.getOrderDetailsByIdOrder(id);
    }

    @PostMapping(value = "/create-order")
    public String createOrders(@RequestBody Orders orders){
        ordersService.createNewOrders(orders);
        return "Thêm thành công!";
    }
}
