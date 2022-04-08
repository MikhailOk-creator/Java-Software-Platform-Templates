package ru.rtu_mirea.practice_11;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestQ {
    @RequestMapping("/Hammer")
    public String rest(){
        System.out.println("HELP ME!!!");
        return "Please, kill me!!!";
    }
}
