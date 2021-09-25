package com.ticket.service;


import com.ticket.model.MessageModel;

public interface MailSendingService {

    void send(MessageModel messageModel);
    void sendTest();

}
