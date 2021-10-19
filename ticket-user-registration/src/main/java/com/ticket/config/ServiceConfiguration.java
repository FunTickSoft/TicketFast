package com.ticket.config;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Getter
@ToString
@Configuration
public class ServiceConfiguration {

    private String nameQueue;

    private String nameExchange;

    private String nameRoutingKey;


    @Value("${service.rabbit.queue}")
    public void setNameQueue(String nameQueue) {
        log.info("serviceNameQueue: {}", nameQueue);
        if(nameQueue.equals("")) {
            log.info("serviceNameQueue set defaults: {}", nameQueue);
            nameQueue = "service.queue";
        }
        this.nameQueue = nameQueue;
    }

    @Value("${service.rabbit.exchange}")
    public void setNameExchange(String nameExchange) {
        log.info("exchangeNameExchange: {}", nameExchange);
        if(nameExchange.equals("")){
            log.info("exchangeNameExchange set defaults: {}", nameExchange);
            nameExchange = "service.exchange";
        }
        this.nameExchange = nameExchange;
    }

    @Value("${service.rabbit.routingKey}")
    public void setNameRoutingKey(String nameRoutingKey) {
        log.info("nameRoutingKey: {}", nameRoutingKey);
        if((nameRoutingKey == "") || (nameRoutingKey == null)) {
            log.info("nameRoutingKey set defaults: {}", nameExchange);
            nameRoutingKey = "key";
        }
        this.nameRoutingKey = nameRoutingKey;
    }




}
