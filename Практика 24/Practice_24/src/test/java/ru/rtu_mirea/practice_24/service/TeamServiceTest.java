package ru.rtu_mirea.practice_24.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rtu_mirea.practice_24.model.Team;
import ru.rtu_mirea.practice_24.repo.TeamRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {
    @Mock
    private TeamRepo teamRepo;

    @Test
    void getTeams() {
        Team testTeam = new Team();
        testTeam.setName("Metallica");
        testTeam.setCreationDate("1981/10/28");
        Mockito.when(teamRepo.findAll()).thenReturn(List.of(testTeam));

        Assertions.assertEquals(1, teamRepo.findAll().size());
        Assertions.assertEquals("Metallica", teamRepo.findAll().get(0).getName());
    }
}