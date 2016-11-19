package pl.akademiakodu.giflib.Reposytory;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.giflib.model.AdverLisementProvider;

import javax.annotation.PostConstruct;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Camillo on 19.11.2016.
 */
@Repository
public class AdsProviderReposytoryImp implements AdsProviderReposytory {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AdverLisementProvider> finalAll() {
        try (Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<AdverLisementProvider> criteria =
                    builder.createQuery(AdverLisementProvider.class);
            criteria.from(AdverLisementProvider.class);
            return  session.createQuery(criteria).getResultList();
        }
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void poligon(){
       logger.info("utworzyliśmi ads provaidr");

        printCompanyYear(1990);
        //wszystkie firmy które maja podwujne "o"

        printCompanyLetter('o');
    }

    private void printCompanyYear(int year){

      try(Session session = sessionFactory.openSession()){
          Criteria criteria  = session.createCriteria(AdverLisementProvider.class);
         List<AdverLisementProvider> result = criteria.add(Restrictions.gt("yearCreated",year)).list();
          logger.info("Stare API " + result);

      }

        try(Session session = sessionFactory.openSession()){
           // Criteria criteria  = session.createCriteria(AdverLisementProvider.class);
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery <AdverLisementProvider> query =  builder.createQuery(AdverLisementProvider.class);

            Root<AdverLisementProvider> from = query.from(AdverLisementProvider.class);

            query.where(
                    builder.greaterThan(from.get("yearCreated"),year)
            );

            List<AdverLisementProvider>  resut = session.createQuery(query).getResultList();
            logger.info("Nowe api" + resut);
        }

        try(Session session = sessionFactory.openSession()){
            Query query =
                    session.createQuery("from AdverLisementProvider  where yearCreated > :year");
         query.setParameter("year", year);
            List<AdverLisementProvider>  resut = query.getResultList();
            logger.info("HQL api" + resut);
        }

    }

    private void printCompanyLetter(char letter) {

        String pattern = "%"  + letter + letter+"%";

        try(Session session = sessionFactory.openSession()){
            Criteria criteria  = session.createCriteria(AdverLisementProvider.class);
            List<AdverLisementProvider> result = criteria.add(Restrictions.gt("companyName",pattern)).list();
            logger.info("Stare API2 " + result);

        }

        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery <AdverLisementProvider> creatyria = builder.createQuery(AdverLisementProvider.class);
            Root<AdverLisementProvider> from = creatyria.from(AdverLisementProvider.class);

            creatyria.where(builder.like(from.get("companyName"),pattern));
            List<AdverLisementProvider> result = session.createQuery(creatyria).getResultList();
            logger.info("Nowe API2 " + result);
        }

        try(Session session = sessionFactory.openSession()){
            Query query =
                    session.createQuery("from AdverLisementProvider  where companyName > :pattern");
            query.setParameter("pattern", pattern);
            List<AdverLisementProvider>  resut = query.getResultList();
            logger.info("HQL2 api" + resut);
        }

    }

}
