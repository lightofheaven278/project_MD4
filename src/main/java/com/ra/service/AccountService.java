package com.ra.service;

import com.ra.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    List<Account> displayAccounts(String email, int page, int size, String direction, String sortBy);

    List<Integer> getListPage(String email, int size);

    Account getAccountById(int accId);

    boolean save(Account account);

    boolean delete(int accId);
}
