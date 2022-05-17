package ru.rtu_mirea.practice_19.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rtu_mirea.practice_19.model.Footballer;

import java.util.List;

@Repository
public interface FootballerRepo extends JpaRepository<Footballer, Long> {
    List<Footballer> findAllByLastName(String lastName);
    List<Footballer> findAllByFirstName(String firstName);
}
