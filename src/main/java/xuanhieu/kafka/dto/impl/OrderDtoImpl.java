package xuanhieu.kafka.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dao.InventoryDao;
import xuanhieu.kafka.dao.OrdersDao;
import xuanhieu.kafka.dao.ProductsDao;
import xuanhieu.kafka.dto.OrderDto;
import xuanhieu.kafka.entity.Inventory;
import xuanhieu.kafka.entity.OrderDetails;
import xuanhieu.kafka.entity.Orders;
import xuanhieu.kafka.entity.Products;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDtoImpl implements OrderDto {
    private static List<OrderDetails>orderDetailsList;
    private static List<OrderDetails>ordersList;
    private static OrderDetails orderDetails;
    private static Products products;
    private static Inventory inventory;


    @Autowired
    OrdersDao ordersDao;

    @Autowired
    InventoryDao inventoryDao;

    @Autowired
    ProductsDao productsDao;



    private Integer totalQuantity(List<OrderDetails> orderDetailsList){
        Integer totalQuantity =0;
        for(int i=0;i<orderDetailsList.size();i++){
            totalQuantity+= orderDetailsList.get(i).getQuantity();
        }
        return totalQuantity;
    }


    private Float totalSales(List<OrderDetails>orderDetails){
        float totalSales = 0;
        for(int i=0;i<orderDetails.size();i++){
            totalSales+=(orderDetails.get(i).getQuantity())*(productsDao.getProductsByIdProduct(orderDetails.get(i).getProducts().getIdProduct()).getPrice());
        }
        return totalSales;
    }


    private void updateInventoryAfterOrder(List<OrderDetails>orderDetails,Orders orders){
        int quantityBefore;
        int quantityAfter;
        int idProduct;
        for(int i=0;i<orderDetails.size();i++){
            quantityBefore = orderDetails.get(i).getQuantity();
            idProduct = orderDetails.get(i).getProducts().getIdProduct();
            quantityAfter = inventoryDao.getInventoryByIdProduct(idProduct).getTotalSales() - quantityBefore;
            inventory = inventoryDao.getInventoryByIdProduct(idProduct);
            inventory.setTotalSales(quantityAfter);
            inventory.setModifiedOn(orders.getCreatedOn());
            inventoryDao.updateInventory(inventory);
        }
    }

    @Override
    public Orders createOrders(Orders orders) {
        orderDetailsList = orders.getOrderDetailsList();
        orders.setTotalQuantity(totalQuantity(orderDetailsList));
        orders.setTotalPrice(totalSales(orderDetailsList));
        ordersList = new ArrayList<>();
        for(int i=0;i<orderDetailsList.size();i++){
            products = orderDetailsList.get(i).getProducts();
            orderDetails = orders.getOrderDetailsList().get(i);
            orderDetails.setOrders(orders);
            orderDetails.setProducts(products);
            ordersList.add(orderDetails);
        }
        orders.setOrderDetailsList(ordersList);
        updateInventoryAfterOrder(orderDetailsList,orders);
        return ordersDao.createNewOrders(orders);
    }
}
