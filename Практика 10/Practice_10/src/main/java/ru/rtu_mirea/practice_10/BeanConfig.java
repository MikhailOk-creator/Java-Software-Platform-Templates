package ru.rtu_mirea.practice_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Junior junior_working() {
        return new Junior();
    }
    @Bean
    public Middle middle_working() {
        return new Middle();
    }
    @Bean
    public Senior senior_working() {
        return new Senior();
    }
}
