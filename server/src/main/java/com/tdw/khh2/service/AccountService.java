package com.tdw.khh2.service;

import com.tdw.khh2.entity.Account;
import com.tdw.khh2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account findAccountById(String id) {
        return accountRepository.findById(id).get();
    }

    public Page<Account> findAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
}
