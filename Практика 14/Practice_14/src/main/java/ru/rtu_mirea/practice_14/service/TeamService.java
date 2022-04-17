package ru.rtu_mirea.practice_14.service;

import ru.rtu_mirea.practice_14.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private List<Team> teamList;

    public TeamService() {
        teamList = new ArrayList<>();
        initialize();
    }

    public void initialize() {
        teamList.add(new Team("Spartak", "18/04/1922"));
        teamList.add(new Team("CSKA", "27/08/1911"));
        teamList.add(new Team("Zenit", "25/05/1925"));
    }

    public void addTeam(Team team) {
        teamList.add(team);
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void deleteTeam(Team team) {
        teamList.remove(team);
    }
}
