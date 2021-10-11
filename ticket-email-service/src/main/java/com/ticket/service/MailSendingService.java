package com.ticket.service;


import com.example.email.model.MessageMail;


public interface MailSendingService {

    void send(MessageMail messageModel);


}
