package com.ra.service;

import com.ra.model.BillDetails;

import java.util.List;

public interface BillDetailService {
    List<BillDetails> displayBillDetail(int billId, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(int billId, int size);

    List<BillDetails> findByBillId(int billId);

    boolean save(BillDetails billDetails);

    boolean delete(int billId);
}
