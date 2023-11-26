package com.ra.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "product_image")
    private String image;
    @Column(name = "product_unit")
    private String unit;
    @Column(name = "product_status")
    private boolean productStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id")
    private Category catalog;
    @OneToMany(mappedBy = "product" ,fetch =  FetchType.LAZY)
    private Set<Image> imageList;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<BillDetails> billDetailsList;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, String description, String image,
                   String unit, boolean productStatus, Category catalog, Set<Image> imageList,
                   List<BillDetails> billDetailsList) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.description = description;
        this.image = image;
        this.unit = unit;
        this.productStatus = productStatus;
        this.catalog = catalog;
        this.imageList = imageList;
        this.billDetailsList = billDetailsList;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getUnit() {
        return unit;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public Category getCatalog() {
        return catalog;
    }

    public Set<Image> getImageList() {
        return imageList;
    }

    public List<BillDetails> getBillDetailsList() {
        return billDetailsList;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void setCatalog(Category catalog) {
        this.catalog = catalog;
    }

    public void setImageList(Set<Image> imageList) {
        this.imageList = imageList;
    }

    public void setBillDetailsList(List<BillDetails> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }
}
