package ru.rtu_mirea.practice_15.service;

import ru.rtu_mirea.practice_15.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {
    @Autowired
    SessionFactory sessionFactory;

    public TeamService(SessionFactory sessionFactory) {
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

    public void addTeam(Team team) {
        session.beginTransaction();
        session.saveOrUpdate(team);
        session.getTransaction().commit();
    }

  /*  public List<Team> getTeams() {
        return session.createQuery("select t from Team t", Team.class).list();
    }
    public List<Team> getTeams(String name, Date creationDate) {
        return session.createQuery("select t from Team t where t.name and t.creationDate ='" + name + creationDate + "'", Team.class).list();
    }

    public void deleteTeam(Team team) {
        session.beginTransaction();

        List<Team> query = session.createQuery("select t from Team t where t.name = '" +
                team.getName() + "'" + " and t.creationDate = '" + team.getCreationDate() + "'", Team.class).list();
        for (Team t : query) {
            session.delete(t);
        }

        session.getTransaction().commit();
    }*/
}
