package com.contactserv.contact.service;

import com.contactserv.contact.model.ContactRequest;

public interface EmailService {
    void sendEmail(ContactRequest request);
}