package ru.rtu_mirea.practice_17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_17.model.Footballer;
import ru.rtu_mirea.practice_17.model.Team;
import ru.rtu_mirea.practice_17.service.FootballerService;

import java.util.List;
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

    @GetMapping("/sort/{c}")
    public ResponseEntity<List<Footballer>> sort(@PathVariable("c") String Criteria) {
        //return service.SortCriteria(Criteria);
        final List<Footballer> footballers = service.SortCriteria(Criteria);
        return footballers != null && !footballers.isEmpty()
                ? new ResponseEntity<>(footballers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
