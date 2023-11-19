FROM openjdk:17-alpine

COPY target/ums_mail_service-0.0.1-SNAPSHOT.jar ums-mail.jar
ENTRYPOINT ["java","-jar","/ums-mail.jar"]