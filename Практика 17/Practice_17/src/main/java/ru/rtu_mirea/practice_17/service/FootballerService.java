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

    public List SortCriteria (String Criteria) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Footballer> footballerCriteriaQuery = builder.createQuery(Footballer.class);

        Root<Footballer> footballer = footballerCriteriaQuery.from(Footballer.class);
        /*footballerCriteriaQuery.select(root).orderBy(builder.asc(root.get(Criteria)));
        Query query = session.createQuery(footballerCriteriaQuery);*/
        Predicate CriteriaPredicate = builder.equal(footballer.get(Criteria), Criteria);
        footballerCriteriaQuery.where(CriteriaPredicate);
        TypedQuery<Footballer> query = session.createQuery(footballerCriteriaQuery);

        return query.getResultList();
    }
}
