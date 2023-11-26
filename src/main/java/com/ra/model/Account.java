package com.ra.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;
    @Column(name = "permission")
    private boolean permission;
    @Column(name = "acc_status")
    private boolean accStatus;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Bill> billList;

    public Account() {
    }

    public Account(int accId, String email, String password, Date created, boolean permission, boolean accStatus,
                   List<Bill> billList) {
        this.accId = accId;
        this.email = email;
        this.password = password;
        this.created = created;
        this.permission = permission;
        this.accStatus = accStatus;
        this.billList = billList;
    }

    public int getAccId() {
        return accId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated() {
        return created;
    }

    public boolean isPermission() {
        return permission;
    }

    public boolean isAccStatus() {
        return accStatus;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public void setAccStatus(boolean accStatus) {
        this.accStatus = accStatus;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
