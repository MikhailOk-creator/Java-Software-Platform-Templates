package ru.rtu_mirea.practice_15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_15.model.Footballer;
import ru.rtu_mirea.practice_15.service.FootballerService;

import java.util.List;
import java.util.UUID;

@RestController
public class FootballerController {
    @Autowired
    private FootballerService service;

    /*@PostMapping("/newfootballer")
    public void post(@RequestBody Footballer footballer) {
        service.addFootballer(footballer);
    }

    @GetMapping("/footballers")
    public List<Footballer> getAll() {
        return service.getFootballers();
    }*/
}
