package ru.rtu_mirea.practice_15.service;

import ru.rtu_mirea.practice_15.model.Footballer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class FootballerService {
    @Autowired
    private final SessionFactory sessionFactory;

    public FootballerService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
        return session.createQuery("select f from Footballer f", Footballer.class).list();
    }

    /*public Footballer getFootballer(String first_name, String last_name) {
        return session.createQuery("select f from Footballer f where f.id = '" + id + "'", Footballer.class).getSingleResult();
    }*/

    public void deleteFootballer(UUID id) {

        session.beginTransaction();

        Footballer temp = session.load(Footballer.class, id);
        session.delete(temp);

        session.getTransaction().commit();

    }
}
