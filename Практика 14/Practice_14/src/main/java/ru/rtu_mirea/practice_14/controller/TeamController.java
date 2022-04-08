package ru.rtu_mirea.practice_14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rtu_mirea.practice_14.Team;
import ru.rtu_mirea.practice_14.service.TeamService;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService service;

    @PostMapping("/postTeam")
    public void postTeam(@RequestBody Team team) {
        service.addTeam(team);
    }

    @GetMapping("/getTeam")
    public List<Team> getAll() {
        return service.getTeamList();
    }

    @DeleteMapping("/deleteTeam")
    public void deleteTeam (@RequestBody Team team) {
        service.deleteTeam(team);
    }
}
