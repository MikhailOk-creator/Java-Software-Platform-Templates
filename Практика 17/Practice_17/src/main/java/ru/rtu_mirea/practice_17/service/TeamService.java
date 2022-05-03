package ru.rtu_mirea.practice_17.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_17.model.Footballer;
import ru.rtu_mirea.practice_17.model.Team;

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
        List<Team> teams = session.createQuery("select t from Team t", Team.class).getResultList();
        return teams;
    }

    public Team getTeam(Long id) {
        return session.createQuery("from Team where t.id = :id", Team.class).getSingleResult();
    }

    public void deleteTeam(Long id) {
        session.beginTransaction();

        Team temp = session.load(Team.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    public List<Team> SortCriteria (String Criteria) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> teamCriteriaQuery = builder.createQuery(Team.class);

        Root<Team> team = teamCriteriaQuery.from(Team.class);
        /*teamCriteriaQuery.select(team).orderBy(builder.asc(team.get(Criteria)));
        Query query = session.createQuery(teamCriteriaQuery);*/
        Predicate CriteriaPredicate = builder.equal(team.get("Criteria"), Criteria);
        teamCriteriaQuery.where(CriteriaPredicate);
        TypedQuery<Team> query = session.createQuery(teamCriteriaQuery);

        return query.getResultList();
    }
}
