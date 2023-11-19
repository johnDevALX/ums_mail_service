package net.ekene.ums_mail_service.service;


import net.ekene.payload.EmailPayload;

public interface MailService {
    void sendMail(EmailPayload email);
}
