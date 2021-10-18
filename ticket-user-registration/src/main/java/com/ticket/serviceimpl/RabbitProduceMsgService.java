package com.ticket.serviceimpl;

import com.example.email.model.MessageMail;
import com.ticket.config.ServiceConfiguration;
import com.ticket.service.IRabbitProduceMsgService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProduceMsgService implements IRabbitProduceMsgService {

    private final RabbitTemplate rabbitTemplate;
    private final ServiceConfiguration configuration;

    @Autowired
    public RabbitProduceMsgService(RabbitTemplate rabbitTemplate, ServiceConfiguration configuration) {
        this.rabbitTemplate = rabbitTemplate;
        this.configuration = configuration;
    }

    @Override
    public void send(MessageMail mail) {
        rabbitTemplate.convertAndSend(configuration.getNameExchange(), configuration.getNameRoutingKey(),mail);
    }
}
