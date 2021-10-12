package com.ticket.config;


import com.ticket.entities.account.Account;
import com.ticket.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class LssUserDetailsService implements UserDetailsService {

    private static final String ROLE_USER = "ROLE_USER";

    private final AccountRepository accountRepository;

    @Autowired
    public LssUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        final Optional<Account> account = accountRepository.findByLoginOrLoginEmail(loginOrEmail);
        if (account.get() == null) {
            throw new UsernameNotFoundException("Account not found with login/email: " + loginOrEmail);
        }
        return new User(
                account.get().getLogin(),
                account.get().getPassword(),
                account.get().getEnabled() ,
                true,
                true,
                true, getAuthorities(ROLE_USER));
    }


}
