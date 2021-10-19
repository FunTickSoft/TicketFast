package com.ticket.service;


import com.ticket.entities.account.Account;

import com.ticket.exceptions.EmailExistsException;

import java.util.Optional;

public interface IAccountService {

    Account registerNewUser(Account account) throws EmailExistsException;

    Account updateExistingUser(Account account) throws EmailExistsException;

    Account findUserByEmail(final String email);


    void saveRegisteredUser(Account account);

    void changeUserPassword(Account account, String password);

    Iterable<Account> findAll();

    Account save(Account account);

    void deleteById(Long id);
}

