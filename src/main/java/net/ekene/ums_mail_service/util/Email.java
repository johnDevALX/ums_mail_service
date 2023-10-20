package net.ekene.ums_mail_service.util;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Email {
    private String firstName;
    private String recipientAddress;
    private String role;

}
