package com.ra.service;

import com.ra.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> displayBill(int page, int size, String direction, String sortBy);

    List<Integer> getListPage(int size);

    Bill getBillById(int billId);

    boolean save(Bill bill);

    boolean delete(int billId);
}
