package com.ticket.seviceimpl;


import com.example.email.model.MessageModel;
import com.ticket.service.MailSendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
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
        log.info("MessageModel: {}", messageModel.toString());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(env.getProperty("spring.mail.fromAddress"));

        log.info("RecipientAddress: {}", messageModel.getRecipientAddress());
        if(messageModel.getRecipientAddress().equals("test")) {
            log.debug("RecipientAddress is test");
            email.setTo(email.getFrom());
            log.debug("email.getTo: {}", email.getTo());
        }

        email.setTo(messageModel.getRecipientAddress());
        email.setText(messageModel.getText());
        email.setSubject(messageModel.getSubject());

        log.info("Email: {}", email);

        try {
            mailSender.send(email);
        } catch (MailException e) {
            log.error("Can't send message: {}", e.getMessage());
        }

    }


    @Override
    public void testSend(String message) {

    }
}
