package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @Column(name = "bill_id")
    private int billId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_Id", referencedColumnName = "acc_id")
    private Account account;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date created;
    @Column(name = "bill_status")
    private int billStatus;
    @OneToMany(mappedBy = "bill", fetch = FetchType.EAGER)
    private List<BillDetails> billDetailsList = new ArrayList<>();

    public Bill() {
    }

    public Bill(int billId, Account account, Date created, int billStatus, List<BillDetails> billDetailsList) {
        this.billId = billId;
        this.account = account;
        this.created = created;
        this.billStatus = billStatus;
        this.billDetailsList = billDetailsList;
    }

    public int getBillId() {
        return billId;
    }

    public Account getAccount() {
        return account;
    }

    public Date getCreated() {
        return created;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public List<BillDetails> getBillDetailsList() {
        return billDetailsList;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public void setBillDetailsList(List<BillDetails> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }
}
