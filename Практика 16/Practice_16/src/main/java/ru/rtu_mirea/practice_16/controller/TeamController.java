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
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService service;

    @PostMapping("/add")
    public void post(@RequestBody Team team) {
        service.addTeam(team);
    }

    @GetMapping("/all")
    public List<Team> getAll() {
        return service.getTeams();
    }

    @GetMapping("/{id}")
    public Team get(@PathVariable Long id) {
        return service.getTeam(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTeam(id);
    }
}
