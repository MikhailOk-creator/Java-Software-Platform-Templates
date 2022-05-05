package ru.rtu_mirea.practice_18.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_18.model.Footballer;
import ru.rtu_mirea.practice_18.model.Team;
import ru.rtu_mirea.practice_18.service.FootballerService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/footballer")
public class FootballerController {
    private FootballerService service;

    @Autowired
    public FootballerController(FootballerService footballerDriver) {
        this.service = footballerDriver;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Footballer footballer) {
        service.addFootballer(footballer);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Footballer>> getAll() {
        final List<Footballer> footballers = service.getFootballers();
        return footballers != null && !footballers.isEmpty()
                ? new ResponseEntity<>(footballers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Footballer> get(@PathVariable("id") Long id) {
        final Footballer footballer = service.getFootballer(id);
        return footballer != null
                ? new ResponseEntity<>(footballer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        final boolean deleted = service.deleteFootballer(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/first_name/{first_name}")
    public ResponseEntity<List<Footballer>> getFootballersByFirstName(@PathVariable(name = "first_name") String first_name) {
        final List<Footballer> footballers = service.findFootballerByFirstName(first_name);
        return footballers != null && !footballers.isEmpty()
                ? new ResponseEntity<>(footballers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/last_name/{last_name}")
    public ResponseEntity<List<Footballer>> getFootballersByLastName(@PathVariable(name = "last_name") String last_name) {
        final List<Footballer> footballers = service.findFootballerByLastName(last_name);
        return footballers != null && !footballers.isEmpty()
                ? new ResponseEntity<>(footballers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
