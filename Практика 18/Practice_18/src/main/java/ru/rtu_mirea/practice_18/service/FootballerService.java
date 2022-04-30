package ru.rtu_mirea.practice_18.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.rtu_mirea.practice_18.model.Footballer;
import ru.rtu_mirea.practice_18.model.Team;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        return session.createQuery("select f from Footballer f", Footballer.class).list();
    }

    public List<Footballer> getFootballer(UUID id) {
        return session.createQuery("select f from Footballer f where f.id ='" + id + "'", Footballer.class).list();
    }

    public void deleteFootballer(Footballer footballer) {
        session.beginTransaction();

        List<Footballer> query = session.createQuery("select f from Footballer f where f.first_name = '" + footballer.getFirst_name() + "'" + " and f.last_name = '" + footballer.getLast_name() + "'", Footballer.class).list();
        for (Footballer f : query) {
            session.delete(f);
        }

        session.getTransaction().commit();
    }

    public void deleteFootballer(UUID id) {
        session.beginTransaction();

        Footballer temp = session.load(Footballer.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    public Team getFootballerByTeam(Long id) {
        return session.createQuery("from Footballer where id = :id", Footballer.class).setParameter("id", id).getSingleResult().getTeam();
    }

    public List SortCriteria (String Criteria) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Footballer> footballerCriteriaQuery = builder.createQuery(Footballer.class);
        Root<Footballer> root = footballerCriteriaQuery.from(Footballer.class);
        footballerCriteriaQuery.select(root).orderBy(builder.asc(root.get(Criteria)));
        Query query = session.createQuery(footballerCriteriaQuery);
        return query.getResultList();
    }
}
