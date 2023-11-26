package com.ra.serviceImp;

import com.ra.model.Bill;
import com.ra.repository.BillRepository;
import com.ra.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    BillRepository billRepository;

    @Override
    public List<Bill> displayBill(int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size,
                direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return billRepository.getBillId(pageable).getContent();
    }

    @Override
    public List<Integer> getListPage(int size) {
        int totalBill = (int) billRepository.count();
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < Math.ceil((float) totalBill / size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public Bill getBillById(int billId) {
        return (Bill) billRepository.findById(billId).get();
    }

    @Override
    public boolean save(Bill bill) {
        return false;
    }

    @Override
    public boolean delete(int billId) {
        return false;
    }
}
