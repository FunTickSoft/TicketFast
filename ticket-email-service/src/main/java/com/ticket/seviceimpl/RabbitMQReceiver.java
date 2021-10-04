package com.ticket.seviceimpl;

import com.example.email.model.MessageModel;
import com.ticket.service.MailSendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RabbitMQReceiver {

    private final MailSendingService service;

    @Autowired
    public RabbitMQReceiver(MailSendingService service) {
        this.service = service;
    }
    @RabbitListener(queues = "#{'${service.name}' + '.queue'}")
    public void receive(MessageModel message) {
        log.info("Received: {}", message);
        service.send(message);
    }


}
