package ru.rtu_mirea.practice_22.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.rtu_mirea.practice_22.model.Team;

import java.util.Date;
import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {
    List<Team> findAllByName(String name);
    List<Team> findAllByCreationDate(Date creationDate);

    @Modifying
    @Query(value = "COPY postgres2.public.teams " +
            "TO 'D:\\My\\SaveTables\\teams.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true) // Файлы хранятся на стороннем накопителе
    void saveTeamsInFile();
}
