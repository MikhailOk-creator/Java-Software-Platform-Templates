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

    public void post(@RequestBody Footballer footballer) {
        service.addFootballer(footballer);
    }

    @GetMapping("/footballers")
    public List<Footballer> getAll() {
        return service.getFootballers();
    }

    @GetMapping("/footballer/{first_name}/{last_name}")
    /*public Footballer get(@PathVariable UUID id, @PathVariable String first_name, @PathVariable String last_name) {
        return service.getFootballer(first_name, last_name);
    }*/

    @DeleteMapping("/footballer/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteFootballer(id);
    }
}
