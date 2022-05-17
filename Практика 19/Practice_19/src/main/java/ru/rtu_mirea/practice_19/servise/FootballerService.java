package ru.rtu_mirea.practice_19.servise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_19.model.Footballer;
import ru.rtu_mirea.practice_19.repo.FootballerRepo;

import java.util.List;

@Service
@Slf4j
public class FootballerService {

    @Autowired
    private FootballerRepo footballerRepo;

    public void addFootballer(Footballer footballer) {
        log.info("Added footballer {}", footballer);
        footballerRepo.save(footballer);
    }

    public List<Footballer> getFootballers() {
        log.info("Read all footballers");
        return  footballerRepo.findAll();
    }

    public Footballer getFootballer(Long id) {
        log.info("Read by id = {}", id);
        return footballerRepo.getById(id);
    }

    public boolean update(Footballer footballer, long id) {
        log.info("Update footballer by id = {}", id);
        footballer.setId(id);
        footballerRepo.save(footballer);
        return true;
    }

    public boolean deleteFootballer(Long id) {
        log.info("Delete footballer by id = {}", id);
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
