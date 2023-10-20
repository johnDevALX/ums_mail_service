package net.ekene.ums_mail_service.util;

import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailPayload {
    private String recipientAddress;
    private Map<String, Object> variables;
    private String templateName;
    private String mailSubject;

}
