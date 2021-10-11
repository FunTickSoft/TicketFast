package com.ticket.service;


import com.example.email.model.MessageMail;
import com.example.response.Response;


public interface MailServiceQuery {

    Response send(MessageMail messageModel);

}
