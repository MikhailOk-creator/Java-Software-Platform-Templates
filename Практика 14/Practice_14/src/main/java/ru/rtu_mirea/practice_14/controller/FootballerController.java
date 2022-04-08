package ru.rtu_mirea.practice_14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_14.Footballer;
import ru.rtu_mirea.practice_14.service.FootballerService;

import java.util.List;

@RestController
public class FootballerController {
    @Autowired
    private FootballerService service;

    @PostMapping("/postFootballer")
    public void post(@RequestBody Footballer footballer) {
        service.add(footballer);
    }

    @GetMapping("/getFootballer")
    public List<Footballer> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/deleteFootballer")
    public void delete(@RequestBody Footballer footballer) {
        service.delete(footballer);
    }
}
