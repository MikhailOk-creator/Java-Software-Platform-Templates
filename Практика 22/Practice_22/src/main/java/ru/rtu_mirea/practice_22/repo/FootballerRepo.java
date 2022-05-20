package ru.rtu_mirea.practice_22.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rtu_mirea.practice_22.model.Footballer;

import java.util.List;

@Repository
public interface FootballerRepo extends JpaRepository<Footballer, Long> {
    List<Footballer> findAllByFirstName(String firstName);
    List<Footballer> findAllByLastName(String lastName);

    @Modifying
    @Query(value = "COPY postgres2.public.footballers " +
            "TO 'C:\\Users\\mikha\\Documents\\МИРЭА\\Шаблоны программных платформ языка Java\\Практики\\Практика 22\\Сохранённые таблицы\\footballers.csv' " +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveFootballerInFile();
}
