package ru.rtu_mirea.practice_15_another_version.repos;

import org.springframework.data.repository.CrudRepository;
import ru.rtu_mirea.practice_15_another_version.model.Footballer;

public interface FootballerRepo extends CrudRepository<Footballer, Integer> {
}
