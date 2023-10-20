package net.ekene.ums_mail_service.service;


import net.ekene.ums_mail_service.util.Email;

import java.util.Map;

public interface MailService {
    void sendMail(Email email, Map<String, Object> variable, String templateName, String subject);
}
