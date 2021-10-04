package com.ticket.servimp;


import com.example.email.model.MessageModel;
import com.ticket.service.MailSendingService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendingImplementation implements MailSendingService {

    private final AmqpTemplate rabbit;


    @Autowired
    public MailSendingImplementation(AmqpTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void send(MessageModel messageModel) {
        rabbit.convertAndSend("service.exchange", messageModel);
    }

    @Override
    public void sendTest() {
        send(MessageModel.builder()
                .subject("Test message")
                .recipientAddress("test")
                .text("This is test message")
                .build());
    }
}
