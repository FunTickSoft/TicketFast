package com.ticket.utils;

import com.ticket.entities.account.Account;
import com.ticket.representative.AccountRepr;

public class Converter {

    public static Account converterAccountRepr(AccountRepr accountRepr) {
        return Account.builder()
                .id(accountRepr.getId())
                .login(accountRepr.getLogin())
                .loginEmail(accountRepr.getLoginEmail())
                .phoneNumber(accountRepr.getPhoneNumber())
                .password(accountRepr.getPassword())
                .status(accountRepr.getStatus())
                .build();
    }


    public static AccountRepr converterAccount(Account account) {
        return AccountRepr.builder()
                .id(account.getId())
                .login(account.getLogin())
                .loginEmail(account.getLoginEmail())
                .phoneNumber(account.getPhoneNumber())
                .password(account.getPassword())
                .status(account.getStatus())
                .accountNonLocked(account.getAccountNonLocked())
                .accountNonExpired(account.getAccountNonExpired())
                .credentialsNonExpired(account.getCredentialsNonExpired())
                .enabled(account.getEnabled())
                .build();
    }



}
