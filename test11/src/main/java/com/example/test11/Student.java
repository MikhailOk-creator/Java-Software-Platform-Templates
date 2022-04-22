package com.example.test11;

import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Size;
@RestController
@ToString
public class Student {
    @Size(min=2, max=50)
    private String name="Phuong Tien Dong";

    @RequestMapping("/Student")
    public String Get(){
        System.out.println("I'm working");
        return name;
    }
}