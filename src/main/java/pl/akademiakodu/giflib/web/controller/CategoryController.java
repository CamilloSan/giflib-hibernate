package pl.akademiakodu.giflib.web.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.akademiakodu.giflib.Reposytory.CategoryReposytory;
import pl.akademiakodu.giflib.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.akademiakodu.giflib.servises.CategoryServises;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CategoryServises categoryServises;

    // Index of all categories
    @RequestMapping("/categories")
//    @SuppressWarnings("unchecked")
    public String listCategories(Model model) {
        // TODO: Get all categories

       try (Session session = sessionFactory.openSession()){
           List<Category> categories = categoryServises.finalAll();
           model.addAttribute("categories",categories);
           return "category/index";
        }

    }

    // Single category page
    @RequestMapping("/categories/{categoryId}")
    public String category(@PathVariable Long categoryId, Model model) {
        // TODO: Get the category given by categoryId
        Category category = null;

        model.addAttribute("category", category);
        return "category/details";
    }

    // Form for adding a new category
    @RequestMapping("categories/add")
    public String formNewCategory(Model model) {
        // TODO: Add model attributes needed for new form

        return "category/form";
    }

    // Form for editing an existing category
    @RequestMapping("categories/{categoryId}/edit")
    public String formEditCategory(@PathVariable Long categoryId, Model model) {
        // TODO: Add model attributes needed for edit form

        return "category/form";
    }

    // Update an existing category
    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.POST)
    public String updateCategory() {
        // TODO: Update category if valid data was received

        // TODO: Redirect browser to /categories
        return null;
    }

    // Add a category
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String addCategory() {
        // TODO: Add category if valid data was received

        // TODO: Redirect browser to /categories
        return null;
    }

    // Delete an existing category
    @RequestMapping(value = "/categories/{categoryId}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Long categoryId) {
        // TODO: Delete category if it contains no GIFs

        // TODO: Redirect browser to /categories
        return null;
    }
}
