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
            "TO 'C:\\Users\\mikha\\Documents\\МИРЭА\\Шаблоны программных платформ языка Java\\Практики\\Практика 22\\Сохранённые таблицы\\teams.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveTeamsInFile();
}
