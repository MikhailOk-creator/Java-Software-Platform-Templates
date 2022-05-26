package ru.rtu_mirea.practice_24.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import ru.rtu_mirea.practice_24.model.Footballer;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class EmailServiceTest {

    @Mock
    private JavaMailSenderImpl javaMailSenderImpl;
    @Autowired
    private EmailService mail;

    @Test
    void sendEmail() {
        Footballer footballer = new Footballer();
        footballer.setFirstName("Sid");
        footballer.setLastName("Barrett");
        Mockito.doNothing().when(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));

        mail.sendEmail("mikhail.okhapkin@yandex.ru", "Spring Boot Info",
                "Footballer "
                        + footballer.getFirstName() + " "
                        + footballer.getLastName() + " added");

        Mockito.verify(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));
    }
}