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
    /*@Autowired
    private FootballerRepo footballerRepo;
    private FootballerService service;

    @GetMapping(path="/all_footballers")
    public String main(Map<String, Object> model) {
        Iterable<Footballer> footballers = footballerRepo.findAll();
        model.put("footballer", footballers);
        return "main";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Footballer> getAllFootballers() {
        // This returns a JSON or XML with the users
        return footballerRepo.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String add(@RequestParam (name = "first_name", required = false) String first_name, @RequestParam (name = "last_name", required = false) String last_name, Map<String, Object> model) {
        Footballer f = new Footballer(first_name, last_name);
        footballerRepo.save(f);

        Iterable<Footballer> footballers = footballerRepo.findAll();
        model.put("footballer", footballers);
        *//*//*@ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Footballer f = new Footballer(first_name, last_name);
        footballerRepo.save(f);*//*
        return "Saved";
    }

    @PostMapping("/footballer")
    public void add(@RequestBody Footballer footballer) {
        service.addF(footballer);
    }*/
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
