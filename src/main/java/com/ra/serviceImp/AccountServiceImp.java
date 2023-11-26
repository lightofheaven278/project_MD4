package com.ra.serviceImp;

import com.ra.model.Account;
import com.ra.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImp implements com.ra.service.AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> displayAccounts(String email, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return accountRepository.getAccountUserName(email, pageable).getContent();
    }

    @Override
    public List<Integer> getListPage(String userName, int size) {
        int totalAccount = accountRepository.countByEmailContains(userName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < Math.ceil((float) totalAccount / size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }

    @Override
    public Account getAccountById(int accId) {
        return accountRepository.findById(accId).get();
    }

    @Override
    public boolean save(Account account) {
        try {
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int accId) {
        try {
            accountRepository.delete(getAccountById(accId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
