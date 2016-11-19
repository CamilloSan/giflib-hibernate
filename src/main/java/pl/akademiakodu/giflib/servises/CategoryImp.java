package pl.akademiakodu.giflib.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.giflib.Reposytory.CategoryReposytory;
import pl.akademiakodu.giflib.model.Category;

import java.util.List;

/**
 * Created by Camillo on 19.11.2016.
 */

@Service
public class CategoryImp implements CategoryServises {
    @Autowired
    private CategoryReposytory categoryReposytory;

    @Override
    public List<Category> finalAll() {
        return categoryReposytory.finalAll();
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
