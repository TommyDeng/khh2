package com.tdw.khh2.repository;

import com.tdw.khh2.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, String>{
    Account findByEmail(String username);
}