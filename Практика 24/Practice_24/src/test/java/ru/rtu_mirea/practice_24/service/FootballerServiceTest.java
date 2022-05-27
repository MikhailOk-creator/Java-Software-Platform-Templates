package ru.rtu_mirea.practice_24.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rtu_mirea.practice_24.model.Footballer;
import ru.rtu_mirea.practice_24.repo.FootballerRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FootballerServiceTest {
    @Mock
    private FootballerRepo footballerRepo;
    @Test
    void getFootballers() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford");
        testFootballer.setLastName("Burton");
        Mockito.when(footballerRepo.findAll()).thenReturn(List.of(testFootballer));

        Assertions.assertEquals(1, footballerRepo.findAll().size());
        Assertions.assertEquals("Clifford", footballerRepo.findAll().get(0).getFirstName());
    }
}