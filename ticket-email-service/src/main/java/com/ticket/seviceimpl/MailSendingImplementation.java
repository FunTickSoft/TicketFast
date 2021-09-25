package com.ticket.seviceimpl;


import com.ticket.model.MessageModel;
import com.ticket.service.MailSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSendingImplementation implements MailSendingService {


    private JavaMailSender mailSender;
    private Environment env;

    @Autowired
    public MailSendingImplementation(JavaMailSender mailSender, Environment env) {
        this.mailSender = mailSender;
        this.env = env;
    }

    @Override
    public void send(MessageModel messageModel)
    {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(env.getProperty("spring.mail.fromAddress"));
        email.setTo(messageModel.getRecipientAddress());
        email.setText(messageModel.getText());
        email.setSubject(messageModel.getSubject());
        try {
            mailSender.send(email);
        } catch (MailException e) {

        }
    }

    @Override
    public void sendTest() {
        send(MessageModel.builder()
                .subject("Hello, Im testing Simple Email")
                .recipientAddress(env.getProperty("spring.mail.fromAddress"))
                .text("Test Simple Email")
                .build()
        );
    }



}
