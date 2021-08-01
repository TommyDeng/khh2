package com.tdw.khh2.repository;

import com.tdw.khh2.entity.AccountRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AccountRoleRepository extends PagingAndSortingRepository<AccountRole, String> {
    List<AccountRole> findByAccountId(String accountId);

    @Query("select r.name from AccountRole a, Role r " +
            "where a.roleId = r.id and a.accountId = ?1 ")
    List<String> findAccountRolesOfSql(String accountId);
}