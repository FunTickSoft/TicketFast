package com.ticket.listener;


import com.example.email.model.MessageMail;
import com.ticket.entities.account.Account;
import com.ticket.events.OnForgotPasswordEvent;
import com.ticket.service.IRabbitProduceMsgService;
import com.ticket.service.ITokenResetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ForgotPasswordListener implements ApplicationListener<OnForgotPasswordEvent> {



    private final ITokenResetService service;
    private final IRabbitProduceMsgService msgService;


    public ForgotPasswordListener(ITokenResetService service, IRabbitProduceMsgService msgService) {
        this.service = service;
        this.msgService = msgService;
    }

    @Override
    public void onApplicationEvent(OnForgotPasswordEvent event) {
        this.forgotPassword(event);
    }

    private void forgotPassword(final OnForgotPasswordEvent event) {
        log.info("User registration complete. Send confirm message to email: {}");
        final Account account = event.getAccount();
        final String token = UUID.randomUUID()
                .toString();
        service.createPasswordResetTokenForUser(account, token);
        msgService.send(
                MessageMail.builder()
                        .recipientAddress(account.getLoginEmail())
                        .subject("Reset Password")
                        .text(messageReset(event.getAppUrl(), token, account))
                        .build()
        );
    }

    private String messageReset(String uRL, String token, Account account) {
        StringBuilder builder = new StringBuilder();
        builder.append(uRL)
                .append("/account/changePassword?id=")
                .append(account.getId())
                .append("&token=")
                .append(token);
        return builder.toString();
    }





}
