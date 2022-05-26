package ru.rtu_mirea.practice_22.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rtu_mirea.practice_22.repo.FootballerRepo;
import ru.rtu_mirea.practice_22.repo.TeamRepo;

@Service
@Slf4j
public class SchedulerService{

    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private FootballerRepo footballerRepo;

    @Scheduled(cron = "0 */1 * * * *")
    @Transactional
    public void saveEntities() {
        teamRepo.saveTeamsInFile();
        footballerRepo.saveFootballerInFile();
        log.info("Entities saved");
    }
}
