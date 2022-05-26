package ru.rtu_mirea.practice_24.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.rtu_mirea.practice_24.model.Team;
import ru.rtu_mirea.practice_24.repo.TeamRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TeamServiceTest {
    @Mock
    private EmailService emailService;
    @Mock
    private TeamRepo teamRepo;
    private TeamService service;

    @Test
    void addTeam() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");

        service.addTeam(testTeam);

        ArgumentCaptor<Team> teamArgumentCaptor = ArgumentCaptor.forClass(Team.class);

        Mockito.verify(teamRepo).save(teamArgumentCaptor.capture());
        Team capturedTeam = teamArgumentCaptor.getValue();
        Assertions.assertThat(capturedTeam).isEqualTo(testTeam);
    }

    @Test
    void getTeam() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");
        testTeam.setId(Long.valueOf(3));
        Mockito.when(teamRepo.findById(testTeam.getId())).thenReturn(Optional.of(testTeam));

        Team expected = service.getTeam(testTeam.getId());

        Mockito.verify(teamRepo).findById(testTeam.getId());
        Assertions.assertThat(expected).isEqualTo(testTeam);
    }

    @Test
    void getTeams() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");
        Mockito.when(teamRepo.findAll()).thenReturn(List.of(testTeam));

        List<Team> expect = service.getTeams();

        Mockito.verify(teamRepo).findAll();
        Assertions.assertThat(expect).isNotNull();
    }

    @Test
    void deleteTeam() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");
        testTeam.setId(Long.valueOf(3));

        service.deleteTeam(testTeam.getId());
        Mockito.verify(teamRepo).deleteById(testTeam.getId());
    }

    @Test
    void findTeamByName() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");

        Mockito.when(teamRepo.findAllByName(testTeam.getName())).thenReturn(List.of(testTeam));

        List<Team> existed = service.findTeamByName(testTeam.getName());
        Assertions.assertThat(existed).isNotNull();
    }

    @Test
    void findTeamByCreationDate() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");

        Mockito.when(teamRepo.findAllByCreationDate(testTeam.getCreationDate())).thenReturn(List.of(testTeam));

        List<Team> existed = service.findTeamByName(testTeam.getName());
        Assertions.assertThat(existed).isNotNull();
    }
}