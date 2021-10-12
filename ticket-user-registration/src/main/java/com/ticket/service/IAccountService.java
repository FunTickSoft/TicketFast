package com.ticket.service;


import com.ticket.entities.account.Account;
import com.ticket.entities.account.security.PasswordResetToken;
import com.ticket.entities.account.security.VerificationToken;
import com.ticket.exceptions.EmailExistsException;

import java.util.Optional;

public interface IAccountService {

    Optional<Account> registerNewUser(Account account) throws EmailExistsException;

    Optional<Account> updateExistingUser(Account account) throws EmailExistsException;

    Optional<Account> findUserByEmail(final String email);

    void createVerificationTokenForUser(Account account, String token);

    Optional<VerificationToken> getVerificationToken(String token);

    void saveRegisteredUser(Account account);

    void createPasswordResetTokenForUser(Account account, String token);

    Optional<PasswordResetToken> getPasswordResetToken(String token);

    void changeUserPassword(Account account, String password);

    Iterable<Account> findAll();

    Optional<Account> save(Account account);

    void deleteById(Long id);
}

