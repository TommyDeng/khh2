package com.tdw.khh2.common;

import com.tdw.khh2.entity.Account;
import com.tdw.khh2.repository.AccountRepository;
import com.tdw.khh2.repository.AccountRoleRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Log
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetailsService - > loadUserByUsername");
        Account account = accountRepository.findByEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("User name not found: " + username);
        }

        List<String> accountRoles = accountRoleRepository.findAccountRolesOfSql(account.getId());
        return new User(account.getEmail(), account.getPasswdEncrypt(),
                accountRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }

}