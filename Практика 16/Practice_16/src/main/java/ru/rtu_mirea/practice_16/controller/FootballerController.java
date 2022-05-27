package ru.rtu_mirea.practice_16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_16.model.Footballer;
import ru.rtu_mirea.practice_16.model.Team;
import ru.rtu_mirea.practice_16.service.FootballerService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/footballer")
public class FootballerController {
    @Autowired
    private FootballerService service;

    @PostMapping("/add")
    public void add(@RequestBody Footballer footballer) {
        service.addFootballer(footballer);
    }

    @GetMapping("/all")
    public @ResponseBody List<Footballer> getAll() {
        return service.getFootballers();
    }

    @GetMapping("/{id}")
    public @ResponseBody Footballer get(@PathVariable("id") Long id) {
        return service.getFootballer(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteFootballer(id);
    }

    @GetMapping(value = "/{footballerId}/team")
    public @ResponseBody Team getFootballerTeam(@PathVariable("footballerId") Long footballerId) {
        return service.getFootballerByTeam(footballerId);
    }
}
