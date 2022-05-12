package ru.rtu_mirea.practice_21.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rtu_mirea.practice_21.model.Team;

import java.util.Date;
import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {
    List<Team> findAllByName(String name);
    List<Team> findAllByCreationDate(Date creationDate);
}