package ru.rtu_mirea.practice_14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_14.model.Footballer;
import ru.rtu_mirea.practice_14.service.FootballerService;

import java.util.List;

@RestController
public class FootballerController {
    @Autowired
    private FootballerService service;

    @GetMapping("/addFootballer/{f_name}/{l_name}")
    public void post(@PathVariable String f_name, @PathVariable String l_name) {
        service.add(new Footballer(f_name, l_name));
    }

    @GetMapping("/getFootballers")
    public List<Footballer> getAll() {
        return service.getAll();
    }
    @GetMapping("/deleteFootballer/{f_name}/{l_name}")
    public void delete(@PathVariable String f_name, @PathVariable String l_name) {
        service.delete(new Footballer(f_name, l_name));
    }
}
