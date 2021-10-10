package com.ticket.seviceimpl;



import com.example.email.model.MessageMail;
import com.ticket.config.RabbitConfigurationProperties;
import com.ticket.service.MailSendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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


    @RabbitListener(bindings = @QueueBinding(value = @Queue("#{rabbitConfigurationProperties.getNameQueue()}"),
    exchange = @Exchange(value = "#{rabbitConfigurationProperties.getNameExchange}"),
    key = "#{rabbitConfigurationProperties.getNameRoutingKey()}"))
    public void onMessage(MessageMail messageModel, Message message) {
        log.info("Get Message from Queue {}, key {}", messageModel, message.getMessageProperties().getReceivedRoutingKey() );
        service.send(messageModel);
        log.info("send email");
    }


//    @RabbitListener(queues = "#{rabbitConfigurationProperties.getNameQueue()}")
//    public void onMessage(MessageMail messageModel, Message message) {
//        log.info("Get Message from Queue {}, key {}", messageModel, message.getMessageProperties().getReceivedRoutingKey() );
//        service.send(messageModel);
//        log.info("send email");
//    }




}
