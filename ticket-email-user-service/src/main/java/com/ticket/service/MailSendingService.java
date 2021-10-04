package com.ticket.service;


import com.example.email.model.MessageModel;

public interface MailSendingService {

    void send(MessageModel messageModel);
    void sendTest();

}
