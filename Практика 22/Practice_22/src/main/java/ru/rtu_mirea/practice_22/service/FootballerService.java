package ru.rtu_mirea.practice_22.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_22.model.Footballer;
import ru.rtu_mirea.practice_22.repo.FootballerRepo;

import java.util.List;

@Service
@Slf4j
public class FootballerService {

    @Autowired
    private FootballerRepo footballerRepo;
    @Autowired
    private EmailService mail;

    public void addFootballer(Footballer footballer) {
        log.info("Added footballer {}", footballer);
        mail.sendEmail("mikhail.okhapkin@yandex.ru", "Spring Boot Info",
                "Footballer "
                        + footballer.getFirstName() + " "
                        + footballer.getLastName() + " added");
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
        Footballer WhichFootballerWillBeDeleted = getFootballer(id);
        log.info("Delete footballer by id = {}", id);

        mail.sendEmail("mikhail.okhapkin@yandex.ru", "Spring Boot Info",
                "Footballer "
                        + WhichFootballerWillBeDeleted.getFirstName() + " "
                        + WhichFootballerWillBeDeleted.getLastName() + " deleted");
        footballerRepo.deleteById(id);
        return true;
    }

    public List<Footballer> findFootballerByFirstName (String first_name) {
        log.info("Find footballers by first name = {}", first_name);
        return footballerRepo.findAllByFirstName(first_name);
    }
    public List<Footballer> findFootballerByLastName(String last_name) {
        log.info("Find footballers by last name = {}", last_name);
        return footballerRepo.findAllByLastName(last_name);
    }
}
