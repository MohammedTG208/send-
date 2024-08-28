package com.example.capstion3.Service;

import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Category;
import com.example.capstion3.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        if (categoryRepository.findAll().isEmpty()){
            throw new APIException("DB is Empty");
        }else {
            return categoryRepository.findAll();
        }
    }
    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }
    public void updateCategory(Category category,Integer id) {
        Category updatedCategory = categoryRepository.findCategoryById(id);
        if (updatedCategory == null){
            throw new APIException("Category not found to update");
        }else {
            updatedCategory.setName(category.getName());
            categoryRepository.save(updatedCategory);
        }
    }
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findCategoryById(id);
        if (category == null){
            throw new APIException("Category not found to delete");
        }else {
            categoryRepository.delete(category);
        }
    }
}
