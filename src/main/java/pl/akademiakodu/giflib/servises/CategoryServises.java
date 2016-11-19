package pl.akademiakodu.giflib.servises;

import pl.akademiakodu.giflib.model.Category;

import java.util.List;

/**
 * Created by Camillo on 19.11.2016.
 */
public interface CategoryServises {

    List<Category> finalAll();
    Category finndById(Long id);
    void save(Category category);
    void delete(Category category);

}
