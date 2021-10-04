package com.ticket.controller;

import com.example.email.model.MessageModel;
import com.ticket.service.MailSendingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/mail_service")
public class MailSendController {


    private static final Logger logger = LoggerFactory.getLogger(MailSendController.class);

    private final MailSendingService mailSendingService;

    @Autowired
    public MailSendController(MailSendingService mailSendingService) {
        this.mailSendingService = mailSendingService;
    }

    @RequestMapping("/email")
    public ModelAndView createMessageEmail() {
        return new ModelAndView("mailform", "message", new MessageModel());
    }

    @RequestMapping("/doSend")
    public ModelAndView doSend(@Valid final MessageModel messageModel, final BindingResult result, final HttpServletRequest request) {
        return new ModelAndView("redirect:/email");
    }


}
