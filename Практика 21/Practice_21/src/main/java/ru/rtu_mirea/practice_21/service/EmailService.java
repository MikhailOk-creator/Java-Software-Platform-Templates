package ru.rtu_mirea.practice_21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class EmailService {

    @Autowired
    private JavaMailSender MailSender;

    @Async
    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mikhail.okhapkin@yandex.ru");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        MailSender.send(message);
    }
}
