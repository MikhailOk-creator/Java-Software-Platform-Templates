package ru.rtu_mirea.practice_15.service;

import ru.rtu_mirea.practice_15.model.Footballer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

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

    public Footballer getFootballer(String first_name, String last_name) {
        return session.createQuery("* from Footballer f where f.firstName and f.lastName = '" + first_name + last_name + "'", Footballer.class).getSingleResult();
    }
}
