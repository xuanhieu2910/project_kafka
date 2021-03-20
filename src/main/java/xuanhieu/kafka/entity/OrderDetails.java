package xuanhieu.kafka.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderDetail;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders orders;

    public OrderDetails() {
    }

    public OrderDetails(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

//    public Orders getOrders() {
//        return orders;
//    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "idOrderDetail=" + idOrderDetail +
                ", quantity=" + quantity +
                ", products=" + products +
                ", orders=" + orders+
                '}';
    }
}
