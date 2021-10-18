package com.ticket.service;


import com.ticket.email.model.MessageMail;


public interface MailSendingService {

    void send(MessageMail messageModel);


}
