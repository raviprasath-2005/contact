package com.contactserv.contact.service;

import com.contactserv.contact.model.ContactRequest;
import com.contactserv.contact.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(ContactRequest request) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("raviprasathveeramani1@gmail.com");
        message.setReplyTo(request.getEmail());

        // YOUR EMAIL
        message.setTo("raviprasathveeramani1@gmail.com");

        message.setSubject("Portfolio Contact: " + request.getSubject());

        message.setText(
                "Name: " + request.getName() + "\n\n" +
                        "Email: " + request.getEmail() + "\n\n" +
                        "Message:\n" + request.getMessage()
        );

        mailSender.send(message);
    }
}