package com.ticket.service;

import com.ticket.entities.account.Account;
import com.ticket.entities.account.security.VerificationToken;


public interface ITokenVerifyService {

    void createVerificationTokenForUser(Account account, String token);

    VerificationToken getVerificationToken(String token);


}
