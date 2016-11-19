package pl.akademiakodu.giflib.Reposytory;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.giflib.model.Category;

import java.util.List;

/**
 * Created by Camillo on 19.11.2016.
 */

public interface CategoryReposytory {
    List<Category> finalAll();
    Category finndById(Long id);
    void save(Category category);
    void delete(Category category);


}
