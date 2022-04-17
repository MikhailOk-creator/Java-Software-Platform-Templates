package ru.rtu_mirea.practice_14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_14.model.Team;
import ru.rtu_mirea.practice_14.service.TeamService;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService service;

    @GetMapping("/addTeam/{name}/{creationDate}")
    public void add(@PathVariable String name, @PathVariable String creationDate) {
        service.addTeam(new Team(name, creationDate));
    }

    @GetMapping("/getTeams")
    public List<Team> getAll() {
        return service.getTeamList();
    }

    @GetMapping("/deleteTeam/{name}/{creationDate}")
    public void deleteTeam (@PathVariable String name, @PathVariable String creationDate) {
        service.deleteTeam(new Team(name, creationDate));
    }
}
