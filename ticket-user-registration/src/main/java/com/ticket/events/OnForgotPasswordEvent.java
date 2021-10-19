package com.ticket.events;


import com.ticket.entities.account.Account;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@Slf4j
public class OnForgotPasswordEvent extends ApplicationEvent  {


    private Account account;
    private String appUrl;

    public OnForgotPasswordEvent(final Account account, final String appUrl) {
        super(account);
        this.account = account;
        this.appUrl = appUrl;
        log.info(account.toString(), appUrl);
    }



}


