package com.ticket.config;

import com.ticket.seviceimpl.RabbitMQReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Value("${service.name:e-send-service}")
    private String serviceName;

    @Value("${exchange.name:service.exchange}")
    private String exchangeName;

    @Bean
    public Queue serviceQueue() {
        return new Queue(serviceName + ".queue");
    }

    @Bean
    public DirectExchange exchange() {
	    return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding userBinding(Queue serviceQueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(serviceQueue)
                .to(exchange)
                .with(serviceName); // routing key
    }


    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
