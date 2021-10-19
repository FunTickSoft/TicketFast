package com.ticket.service;


import com.ticket.email.model.MessageMail;
import com.ticket.response.Response;


public interface MailServiceQuery {

    Response send(MessageMail messageModel);

}
