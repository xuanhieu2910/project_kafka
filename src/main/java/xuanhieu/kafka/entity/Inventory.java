package xuanhieu.kafka.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventory;
    @Column(name = "created_on", length = 255, nullable = false)
    private String createdOn;

    @Column(name = "modified_on", nullable = false, length = 255)
    private String modifiedOn;

    @Column(name = "total_inventory", nullable = false)
    private Integer totalInventory;
    @Column(name = "total_sales", nullable = false)
    private Integer totalSales;
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Products products;


    public Inventory() {
    }

    public Inventory(String createdOn, String modifiedOn, Integer totalInventory, Integer totalSales, String status, Products products) {
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.totalInventory = totalInventory;
        this.totalSales = totalSales;
        this.status = status;
        this.products = products;
    }

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Integer getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Integer totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
