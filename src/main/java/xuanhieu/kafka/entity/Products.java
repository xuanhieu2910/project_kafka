package xuanhieu.kafka.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    private Integer idProduct;
    @Column(name = "name_product", length = 255, nullable = false)
    private String nameProduct;
    @Column(name = "import_price", nullable = false)
    private Float importPrice;
    @Column(name = "price", nullable = false)
    private Float price;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "date_of_manufacture", length = 255, nullable = false)
    private String dateOfManufacture;
    @Column(name = "delete_date", length = 255)
    private String deleteDate;
    @Column(name = "expiry_date", length = 255, nullable = false)
    private String expiryDate;
    @Column(name = "create_on", length = 255, nullable = false)
    private String createdOn;
    @Column(name = "modified_on", length = 255, nullable = false)
    private String modifiedOn;
    @Column(name = "status", length = 255, nullable = false)
    private String status;

    @OneToMany(
            mappedBy = "products",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<OrderDetails> orderDetails;


    @OneToOne(
            mappedBy = "products",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Inventory inventory;


    public Products() {
    }

    public Products(Integer idProduct, String nameProduct, Float importPrice, Float price, Integer quantity,
                    String dateOfManufacture, String deleteDate, String expiryDate, String createdOn, String modifiedOn, String status) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.importPrice = importPrice;
        this.price = price;
        this.quantity = quantity;
        this.dateOfManufacture = dateOfManufacture;
        this.deleteDate = deleteDate;
        this.expiryDate = expiryDate;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.status = status;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setImportPrice(Float importPrice) {
        this.importPrice = importPrice;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }


    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Float getImportPrice() {
        return importPrice;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public String getStatus() {
        return status;
    }

//    public List<OrderDetails> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public Inventory getInventory() {
//        return inventory;
//    }




    @Override
    public String toString() {
        return "Products{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", importPrice=" + importPrice +
                ", price=" + price +
                ", quantity=" + quantity +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", deleteDate='" + deleteDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", status='" + status + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
