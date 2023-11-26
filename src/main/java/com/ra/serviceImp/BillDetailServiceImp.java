package com.ra.serviceImp;

import com.ra.model.BillDetails;
import com.ra.repository.BillDetailsRepository;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BillDetailServiceImp implements BillDetailService {
    @Autowired
    private BillDetailsRepository billDetailsRepository;

    @Override
    public List<BillDetails> displayBillDetail(int billId, int page, int size, String direction, String sortBy) {
        PageRequest pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return billDetailsRepository.getBillDetail(billId, pageable).getContent();
    }

    @Override
    public List<Integer> getListPage(int billId, int size) {
        int totalBillDetail = billDetailsRepository.countByBill_BillId(billId);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < Math.ceil((float) totalBillDetail / size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public List<BillDetails> findByBillId(int billId) {
        return billDetailsRepository.findByBill_BillId(billId);
    }

    @Override
    public boolean save(BillDetails billDetails) {
        try {
            billDetailsRepository.save(billDetails);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int billId) {
        try {
            List<BillDetails> billDetailsList = findByBillId(billId);
            billDetailsRepository.deleteAll(billDetailsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
