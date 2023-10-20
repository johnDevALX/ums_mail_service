package net.ekene.ums_mail_service.service;


import net.ekene.ums_mail_service.util.EmailPayload;

import java.util.Map;

public interface MailService {
    void sendMail(EmailPayload email);
}
