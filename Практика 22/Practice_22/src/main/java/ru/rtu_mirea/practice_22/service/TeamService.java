package ru.rtu_mirea.practice_22.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_22.model.Team;
import ru.rtu_mirea.practice_22.repo.TeamRepo;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Service
public class TeamService {

    private TeamRepo teamRepo;
    @Autowired
    private EmailService mail;
    @Autowired
    TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public void addTeam(Team team) {
        mail.sendEmail("mikhail.okhapkin@yandex.ru", "Spring Boot Info",
                "Team " + team.getName() + " added");
        teamRepo.save(team);
    }

    public List<Team> getTeams() {
        return teamRepo.findAll();
    }

    public Team getTeam(Long id) {
        return teamRepo.getById(id);
    }

    public boolean deleteTeam(Long id) {
        Team WhichTeamWillBeDeleted = getTeam(id);
        mail.sendEmail("mikhail.okhapkin@yandex.ru", "Spring Boot Info",
                "Team " + WhichTeamWillBeDeleted.getName() + " deleted");
        teamRepo.deleteById(id);
        return true;
    }

    public List<Team> findTeamByName(String name) {
        return teamRepo.findAllByName(name);
    }
    public List<Team> findTeamByCreationDate(Date creationDate) {
        return teamRepo.findAllByCreationDate(creationDate);
    }
}
