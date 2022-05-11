package ru.rtu_mirea.practice_20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_20.model.Team;
import ru.rtu_mirea.practice_20.service.TeamService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/team")
public class TeamController {
    @Autowired
    private TeamService service;

    @PostMapping("/add")
    public ResponseEntity<?> post(@RequestBody Team team) {
        service.addTeam(team);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAll() {
        final List<Team> teams = service.getTeams();
        return teams != null && !teams.isEmpty()
                ? new ResponseEntity<>(teams, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> get(@PathVariable Long id) {
        final Team team = service.getTeam(id);
        return team != null
                ? new ResponseEntity<>(team, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        final boolean deleted = service.deleteTeam(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Team>> findTeamByName(@PathVariable(name="name") String name) {
        final List<Team> teams = service.findTeamByName(name);
        return teams != null && !teams.isEmpty()
                ? new ResponseEntity<>(teams, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/creationDate/{creationDate}")
    public ResponseEntity<List<Team>> findTeamByCreationDate(@PathVariable(name="creationDate") Date creationDate) {
        final List<Team> teams = service.findTeamByCreationDate(creationDate);
        return teams != null && !teams.isEmpty()
                ? new ResponseEntity<>(teams, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
