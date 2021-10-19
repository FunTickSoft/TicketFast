package com.ticket.rest;


import com.ticket.email.model.MessageMail;
import com.ticket.response.Response;
import com.ticket.exceptions.BadRequestException;
import com.ticket.service.MailServiceQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Student resource API", description = "API allows you to manipulate data Student resources")
@RestController
@RequestMapping("/api/v1/email")
public class MailServiceREST {

    private final MailServiceQuery service;

    @Autowired
    public MailServiceREST(MailServiceQuery service) {
        this.service = service;
    }


    @Operation(summary = "Send Msg Mail")
    @PostMapping(path = "/send", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> sendMsg(@RequestBody MessageMail model) {
        log.info("Get request /send with Request Body: {}", model);
        Response response = service.send(model);
        if(response.getCode() !=0) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<Response> badRequestException(BadRequestException e) {
        return new ResponseEntity<>(Response.builder().message(e.getMessage()).code(400).build(),HttpStatus.BAD_REQUEST);
    }



}
