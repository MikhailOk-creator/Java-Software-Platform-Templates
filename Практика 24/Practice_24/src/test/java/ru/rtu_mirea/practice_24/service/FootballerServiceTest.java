package ru.rtu_mirea.practice_24.service;


import org.assertj.core.api.Assertions;
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
    private EmailService emailService;
    @Mock
    private FootballerRepo footballerRepo;
    private FootballerService service;

    @Test
    void addFootballer() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");

        service.addFootballer(testFootballer);

        ArgumentCaptor<Footballer> footballerArgumentCaptor = ArgumentCaptor.forClass(Footballer.class);

        Mockito.verify(footballerRepo).save(footballerArgumentCaptor.capture());
        Footballer capturedFootballer = footballerArgumentCaptor.getValue();
        Assertions.assertThat(capturedFootballer).isEqualTo(testFootballer);
    }

    @Test
    void getFootballer() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");
        testFootballer.setId(Long.valueOf(24));
        Mockito.when(footballerRepo.findById(testFootballer.getId())).thenReturn(Optional.of(testFootballer));

        Footballer expected = service.getFootballer(testFootballer.getId());

        Mockito.verify(footballerRepo).findById(testFootballer.getId());
        Assertions.assertThat(expected).isEqualTo(testFootballer);
    }

    @Test
    void getFootballers() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");
        Mockito.when(footballerRepo.findAll()).thenReturn(List.of(testFootballer));

        List<Footballer> expect = service.getFootballers();

        Mockito.verify(footballerRepo).findAll();
        Assertions.assertThat(expect).isNotNull();
    }

    @Test
    void update() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");
        testFootballer.setId(Long.valueOf(24));

        service.update(testFootballer, testFootballer.getId());
        Mockito.verify(footballerRepo).save(testFootballer);
    }

    @Test
    void deleteFootballer() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");
        testFootballer.setId(Long.valueOf(24));

        service.deleteFootballer(testFootballer.getId());
        Mockito.verify(footballerRepo).deleteById(testFootballer.getId());
    }

    @Test
    void findFootballerByFirstName() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");

        Mockito.when(footballerRepo.findAllByFirstName(testFootballer.getFirstName())).thenReturn(List.of(testFootballer));

        List<Footballer> existed = service.findFootballerByFirstName(testFootballer.getFirstName());
        Assertions.assertThat(existed).isNotNull();
    }

    @Test
    void findFootballerByLastName() {
        Footballer testFootballer = new Footballer();
        testFootballer.setFirstName("Clifford ");
        testFootballer.setLastName("Burton");

        Mockito.when(footballerRepo.findAllByLastName(testFootballer.getLastName())).thenReturn(List.of(testFootballer));

        List<Footballer> existed = service.findFootballerByLastName(testFootballer.getLastName());
        Assertions.assertThat(existed).isNotNull();
    }
}