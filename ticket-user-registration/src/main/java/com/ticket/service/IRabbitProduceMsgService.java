package com.ticket.service;

import com.ticket.email.model.MessageMail;

public interface IRabbitProduceMsgService {

    void send(MessageMail mail);

}
