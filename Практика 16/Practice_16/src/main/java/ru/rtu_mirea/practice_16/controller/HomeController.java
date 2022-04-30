package ru.rtu_mirea.practice_16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rtu_mirea.practice_16.model.Footballer;

import java.awt.*;

@Controller
public class HomeController {
    @GetMapping(value = "/home")
    public @ResponseBody String hello(@RequestBody Footballer footballer) {
        return "Hello";
    }
}
