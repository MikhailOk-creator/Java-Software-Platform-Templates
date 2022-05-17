package ru.rtu_mirea.practice_18.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_18.model.Footballer;
import ru.rtu_mirea.practice_18.repo.FootballerRepo;

import java.util.List;

@Service
@Slf4j
public class FootballerService {
    private FootballerRepo footballerRepo;

    @Autowired
    FootballerService(FootballerRepo footballerRepo) {
        this.footballerRepo = footballerRepo;
    }

    public void addFootballer(Footballer footballer) {
        footballerRepo.save(footballer);
    }

    public List<Footballer> getFootballers() {
        return  footballerRepo.findAll();
    }

    public Footballer getFootballer(Long id) {
        return footballerRepo.getById(id);
    }

    public boolean update(Footballer footballer, long id) {
        footballer.setId(id);
        footballerRepo.save(footballer);
        return true;
    }

    public boolean deleteFootballer(Long id) {
        footballerRepo.deleteById(id);
        return true;
    }

    public List<Footballer> findFootballerByFirstName (String firstName) {
        return footballerRepo.findAllByFirstName(firstName);
    }
    public List<Footballer> findFootballerByLastName(String lastName) {
        return footballerRepo.findAllByLastName(lastName);
    }
}
