package com.contactserv.contact.controller;

import com.contactserv.contact.model.ContactRequest;
import com.contactserv.contact.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://your-vercel-app.vercel.app"
})
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @Valid @RequestBody ContactRequest request
    ) {
        emailService.sendEmail(request);
        return ResponseEntity.ok("Email sent successfully!");
    }
}