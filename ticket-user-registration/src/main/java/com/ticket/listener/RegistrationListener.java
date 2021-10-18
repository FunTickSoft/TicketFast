package com.ticket.listener;


import com.ticket.entities.account.Account;
import com.ticket.events.OnRegistrationCompleteEvent;
import com.ticket.service.ITokenVerifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {


    private final ITokenVerifyService service;

    @Autowired
    public RegistrationListener(ITokenVerifyService service) {
        this.service = service;
    }


    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        log.info("Registration event start: event {}", event.toString());
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {

        final Account account = event.getAccount();
        final String token = UUID.randomUUID()
            .toString();

        service.createVerificationTokenForUser(account, token);

    }




}
