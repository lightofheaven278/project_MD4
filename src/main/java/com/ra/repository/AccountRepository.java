package com.ra.repository;

import com.ra.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account as a where a.email like %?1%")
    Page<Account> getAccountUserName(String email, Pageable pageable);

    int countByEmailContains(String email);
}
