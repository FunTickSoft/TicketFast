package com.ticket.service;

import com.ticket.entities.account.Account;
import com.ticket.entities.account.security.PasswordResetToken;



public interface ITokenResetService {

    void createPasswordResetTokenForUser(Account account, String token);

    PasswordResetToken getPasswordResetToken(String token);
}
