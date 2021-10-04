package com.ticket.rest;


import com.example.email.model.MessageModel;
import com.ticket.service.MailSendingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Student resource API", description = "API allows you to manipulate data Student resources")
@RestController
@RequestMapping("/api/v1/email")
public class MailServiceREST {

    private final MailSendingService service;

    @Autowired
    public MailServiceREST(MailSendingService service) {
        this.service = service;
    }


    @Operation(summary = "Send Email Message")
    public void sendMsg(MessageModel model) {
        log.info(model.toString());

    }



}
