package com.ticket.servimp;


import com.example.email.model.MessageMail;
import com.example.response.Response;
import com.ticket.config.ServiceConfiguration;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MailServiceQueryImp implements com.ticket.service.MailServiceQuery {

    private final AmqpTemplate rabbit;

    private ServiceConfiguration configuration;

    @Autowired
    public MailServiceQueryImp(AmqpTemplate rabbit, ServiceConfiguration configuration) {
        this.rabbit = rabbit;
        this.configuration = configuration;
    }

    @Override
    public Response send(MessageMail messageModel) {
        try {
            rabbit.convertAndSend(configuration.getNameExchange(), messageModel);
        }catch (AmqpException e){
            return Response.builder().message(e.getMessage()).code(100).build();
        }
        return Response.builder().message("Success").code(0).build();
    }

}
