package pl.akademiakodu.giflib.Reposytory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.giflib.model.Category;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Camillo on 19.11.2016.
 */
@Repository
public class CategoryReposytoryImp implements CategoryReposytory {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> finalAll() {
        try (Session session = sessionFactory.openSession()){
           CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Category> criteria = builder.createQuery(Category.class);
            criteria.from(Category.class);
            List<Category> categories = session.createQuery(criteria).getResultList();
            return categories;
        }
    }

    @Override
    public Category finndById(Long id) {


        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Category category) {

    }
}
