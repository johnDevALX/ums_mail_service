package net.ekene.ums_mail_service.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ekene.payload.EmailPayload;
import net.ekene.ums_mail_service.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqConsumer {
    private final MailService mailService;

    @RabbitListener(queues = {"ums_queue"})
    public void consumeMessage(EmailPayload emailPayload){
        log.info("payload consumed {}", emailPayload.toString());
        mailService.sendMail(emailPayload);
    }
}
