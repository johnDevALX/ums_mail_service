package net.ekene.ums_mail_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ekene.ums_mail_service.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/email")
public class MailController {

    @PostMapping("send-email")
    public ResponseEntity<?> sendEmail(@RequestBody String text){
        log.info("payload {}", text);
        return ResponseEntity.ok(text);
    }
}
