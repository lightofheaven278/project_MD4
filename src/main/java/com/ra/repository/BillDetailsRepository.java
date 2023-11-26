package com.ra.repository;

import com.ra.model.BillDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailsRepository extends JpaRepository<BillDetails, Integer> {
    @Query("select bd from BillDetails as bd where bd.bill.billId = ?1")
    Page<BillDetails> getBillDetail(int billId, Pageable pageable);
    int countByBill_BillId(int billId);
    List<BillDetails> findByBill_BillId(int billId);
}
