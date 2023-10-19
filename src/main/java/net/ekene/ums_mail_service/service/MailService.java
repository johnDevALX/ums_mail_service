package net.ekene.ums_mail_service.service;


import net.ekene.ums_mail_service.util.Email;

public interface MailService {
    void sendMail(Email email);
}
