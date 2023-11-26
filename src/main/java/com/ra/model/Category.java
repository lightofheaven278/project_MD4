package com.ra.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogId;
    @Column(name = "catalog_name")
    private String catalogName;
    @Column(name = "description")
    private String description;
    @Column(name = "catalog_status")
    private boolean catalogStatus;
    @OneToMany(mappedBy = "catalog", fetch = FetchType.EAGER)
    private List<Product> productList;

    public Category() {
    }

    public Category(int catalogId, String catalogName, String description, boolean catalogStatus,
                    List<Product> productList) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
        this.productList = productList;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
