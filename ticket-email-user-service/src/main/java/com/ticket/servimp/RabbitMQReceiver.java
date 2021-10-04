package com.ticket.servimp;


import com.example.email.model.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@Slf4j
@RabbitListener(queues = "#{'${service.name}' + '.queue'}")
public class RabbitMQReceiver {

    public void receive(MessageModel message) {
        log.info("Received: {}", message);
    }


}
