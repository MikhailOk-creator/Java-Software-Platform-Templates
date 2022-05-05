package ru.rtu_mirea.practice_18.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_18.model.Footballer;
import ru.rtu_mirea.practice_18.model.Team;
import ru.rtu_mirea.practice_18.repo.FootballerRepo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Service
public class FootballerService {
    private final SessionFactory sessionFactory;

    private FootballerRepo footballerRepo;

    public void addFootballer(Footballer footballer) {
        footballerRepo.save(footballer);
    }

    public List<Footballer> getFootballers() {
        return  footballerRepo.findAll();
    }

    public Footballer getFootballer(Long id) {
        return footballerRepo.getById(id);
    }

    public boolean update(Footballer footballer, long id) {
        footballer.setId(id);
        footballerRepo.save(footballer);
        return true;
    }

    public boolean deleteFootballer(Long id) {
        footballerRepo.deleteById(id);
        return true;
    }

    public List<Footballer> findFootballerByFirstName (String first_name) {
        return footballerRepo.findAllByFirst_name(first_name);
    }
    public List<Footballer> findFootballerByLastName(String last_name) {
        return footballerRepo.findAllByLast_name(last_name);
    }
}
