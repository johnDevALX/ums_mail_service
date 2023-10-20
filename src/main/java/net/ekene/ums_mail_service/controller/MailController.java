package net.ekene.ums_mail_service.controller;

import lombok.RequiredArgsConstructor;
import net.ekene.ums_mail_service.service.MailService;
import net.ekene.ums_mail_service.util.EmailPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/email")
public class MailController {
    private final MailService mailService;

    @PostMapping("send-email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailPayload email){
        mailService.sendMail(email);
        return ResponseEntity.ok("EmailPayload Sent");
    }
}
