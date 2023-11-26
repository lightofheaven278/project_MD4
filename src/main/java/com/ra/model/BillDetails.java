package com.ra.model;

import javax.persistence.*;

@Entity
@Table(name = "Bill_detail")
public class BillDetails {
    @Id
    @Column(name = "bill_detail_id")
    private int billDetailId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Column(name = "import_price")
    private float price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "into_money", columnDefinition = "DOUBLE DEFAULT (price * quantity)")
    private double totalPayment;

    public BillDetails() {
    }

    public BillDetails(int billDetailId, Bill bill, Product product, float price, int quantity, double totalPayment) {
        this.billDetailId = billDetailId;
        this.bill = bill;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.totalPayment = totalPayment;
    }

    public int getBillDetailId() {
        return billDetailId;
    }

    public Bill getBill() {
        return bill;
    }

    public Product getProduct() {
        return product;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setBillDetailId(int billDetailId) {
        this.billDetailId = billDetailId;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
