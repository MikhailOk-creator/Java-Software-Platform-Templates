package ru.rtu_mirea.practice_17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_17.model.Footballer;
import ru.rtu_mirea.practice_17.model.Team;
import ru.rtu_mirea.practice_17.service.FootballerService;

import java.util.List;
import java.util.UUID;

@Controller
public class FootballerController {
    @Autowired
    private FootballerService service;

    @PostMapping("/footballer")
    public void add(@RequestBody Footballer footballer) {
        service.addFootballer(footballer);
    }

    @GetMapping("/footballers")
    public List<Footballer> getAll() {
        return service.getFootballers();
    }

    @GetMapping("/footballer/{id}")
    public List<Footballer> get(@PathVariable UUID id) {
        return service.getFootballer(id);
    }

    @DeleteMapping("/footballer/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteFootballer(id);
    }

    @GetMapping(value = "/footballer/{footballerId}/team")
    public @ResponseBody Team getFootballerTeam(@PathVariable("footballerId") Long footballerId) {
        return service.getFootballerByTeam(footballerId);
    }

    @GetMapping("/footballer/sort_f/{c}")
    public List sort_t(@PathVariable("c") String Criteria) {
        return service.SortCriteria(Criteria);
    }
}
