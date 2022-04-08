package ru.rtu_mirea.practice_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Practice10Application {

    public static void main(String[] args) {

        SpringApplication.run(Practice10Application.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        Junior junior = applicationContext.getBean(Junior.class);
        Middle middle = applicationContext.getBean(Middle.class);
        Senior senior = applicationContext.getBean(Senior.class);

        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }

}
