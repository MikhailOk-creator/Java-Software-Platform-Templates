package ru.rtu_mirea.practice_16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_16.model.Team;
import ru.rtu_mirea.practice_16.service.TeamService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
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

    @GetMapping("/team/{id}")
    public List<Team> get(@PathVariable UUID id) {
        return service.getTeam(id);
    }

    @DeleteMapping("/team/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteTeam(id);
    }
    @GetMapping("/ADDTeam/{name}/{creationDate}")
    public void adds(@PathVariable String name, @PathVariable Date creationDate) {
        Team t = new Team(name, creationDate);
        service.addTeam(t);
    }
}
