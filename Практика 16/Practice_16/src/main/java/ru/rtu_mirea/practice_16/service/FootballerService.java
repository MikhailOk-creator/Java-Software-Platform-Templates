package ru.rtu_mirea.practice_16.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_16.model.Footballer;
import ru.rtu_mirea.practice_16.model.Team;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Service
public class FootballerService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void addFootballer(Footballer footballer) {
        session.beginTransaction();
        session.saveOrUpdate(footballer);
        session.getTransaction().commit();
    }

    public List<Footballer> getFootballers() {
        List<Footballer> footballers = session.createQuery("select f from Footballer f", Footballer.class).getResultList();
        return  footballers;
    }

    public Footballer getFootballer(Long id) {
        return session.createQuery("from Footballer where f.id = :id", Footballer.class).getSingleResult();
    }

    public Team getFootballerByTeam(Long id) {
        return session.createQuery("from Footballer where f.id = :id", Footballer.class).setParameter("id", id).getSingleResult().getTeam();
    }

    public void deleteFootballer(Long id) {
        session.beginTransaction();

        Footballer temp = session.load(Footballer.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}
