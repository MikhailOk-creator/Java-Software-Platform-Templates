package ru.rtu_mirea.practice_15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_15.model.Team;
import ru.rtu_mirea.practice_15.service.TeamService;

import java.util.List;
import java.util.UUID;

@RestController
public class TeamController {
    @Autowired
    private TeamService service;

    @PostMapping("/team")
    public void post(@RequestBody Team team) {
        service.addTeam(team);
    }

    @GetMapping("/teams")
    public List<Team> getAll() {
        return service.getTeams();
    }

    @GetMapping("/team/{name}/{creationDate}")
    public List<Team> get(@PathVariable String name, @PathVariable String creationDate) {
        return service.getTeam(name, creationDate);
    }

    @DeleteMapping("/team/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteTeam(id);
    }
}
