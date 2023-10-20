package net.ekene.ums_mail_service.service.implementations;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import net.ekene.ums_mail_service.service.MailService;
import net.ekene.ums_mail_service.service.ThymeleafService;
import net.ekene.ums_mail_service.util.EmailPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;
    private final ThymeleafService thymeleafService;

    @Value("${spring.mail.username}")
    private String name;

    @Override
    public void sendMail(EmailPayload email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            messageHelper.setTo(email.getRecipientAddress());
//            Object[] bccObject = dto.getMailCC().toArray();
//            String[] bcc = Arrays.copyOf(bccObject, bccObject.length, String[].class);
//            messageHelper.setBcc(bcc);

//            Map<String, Object> variables = new HashMap<>();
//            variables.put("firstName", email.getFirstName());
//            variables.put("email", email.getEmail());
//            variables.put("role", email.getRole());
            messageHelper.setText(thymeleafService.createContent(email.getTemplateName(), email.getVariables()), true);
            messageHelper.setFrom(name);
            messageHelper.setSubject(email.getMailSubject());

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
