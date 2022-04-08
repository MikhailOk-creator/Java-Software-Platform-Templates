package ru.rtu_mirea.practice_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Practice12Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice12Application.class, args);
        ApplicationContext ac = new AnnotationConfigApplicationContext(Controller.class);
        Controller cont = ac.getBean(Controller.class);
    }

}
