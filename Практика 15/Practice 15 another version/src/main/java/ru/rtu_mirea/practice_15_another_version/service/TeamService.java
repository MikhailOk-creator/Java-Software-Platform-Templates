package ru.rtu_mirea.practice_15_another_version.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_15_another_version.model.Team;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Service
public class TeamService {
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

    public void addTeam(Team team) {
        session.beginTransaction();
        session.saveOrUpdate(team);
        session.getTransaction().commit();
    }

    public List<Team> getTeams() {
        return session.createQuery("select t from Team t", Team.class).list();
    }

    public List<Team> getTeam(UUID id) {
        return session.createQuery("select t from Team t where t.id ='" + id + "'", Team.class).list();
    }

    public void deleteTeam(Team team) {
        session.beginTransaction();

        List<Team> query = session.createQuery("select t from Team t where t.name = '" + team.getName() + "'" + " and t.creationDate = '" + team.getCreationDate() + "'", Team.class).list();
        for (Team t : query) {
            session.delete(t);
        }

        session.getTransaction().commit();
    }

    public void deleteTeam(UUID id) {
        session.beginTransaction();

        Team temp = session.load(Team.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}
