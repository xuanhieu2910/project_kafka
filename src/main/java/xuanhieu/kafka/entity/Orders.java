package xuanhieu.kafka.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrders;
    @Column(name = "create_on", nullable = false, length = 255)
    private String createdOn;
    @Column(name = "total_price", nullable = false)
    private Float totalPrice;
    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;

    @OneToMany(
            mappedBy = "orders",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderDetails> orderDetailsList;



    public Orders() {
    }

    public Orders(Integer idOrders, String createdOn, Float totalPrice, Integer totalQuantity) {
        this.idOrders = idOrders;
        this.createdOn = createdOn;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }

    public Integer getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }


    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrders=" + idOrders +
                ", createdOn='" + createdOn + '\'' +
                ", totalPrice=" + totalPrice +
                ", totalQuantity=" + totalQuantity +
                ", orderDetailsList=" + orderDetailsList+
                '}';
    }
}
