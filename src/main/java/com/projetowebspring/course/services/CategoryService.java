package com.projetowebspring.course.services;

import com.projetowebspring.course.entities.Category;
import com.projetowebspring.course.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepositories categoryRepositories;
    public List<Category> findAll(){
        return categoryRepositories.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepositories.findById(id);
        return category.get();
    }
}
