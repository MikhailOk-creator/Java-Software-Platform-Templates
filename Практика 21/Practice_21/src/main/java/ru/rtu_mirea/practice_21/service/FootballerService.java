package ru.rtu_mirea.practice_21.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_21.model.Footballer;
import ru.rtu_mirea.practice_21.repo.FootballerRepo;

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
                        + footballer.getFirst_name() + " "
                        + footballer.getLast_name() + " added");
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
                        + WhichFootballerWillBeDeleted.getFirst_name() + " "
                        + WhichFootballerWillBeDeleted.getLast_name() + " deleted");
        footballerRepo.deleteById(id);
        return true;
    }

    public List<Footballer> findFootballerByFirstName (String first_name) {
        log.info("Find footballers by first name = {}", first_name);
        return footballerRepo.findAllByFirst_name(first_name);
    }
    public List<Footballer> findFootballerByLastName(String last_name) {
        log.info("Find footballers by last name = {}", last_name);
        return footballerRepo.findAllByLast_name(last_name);
    }
}
