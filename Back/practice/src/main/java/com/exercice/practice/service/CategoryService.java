package com.exercice.practice.service;

import com.exercice.practice.model.CategoryEnt;
import com.exercice.practice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEnt save(@Validated CategoryEnt category) {
        return categoryRepository.save(category);
    }

    public CategoryEnt findById(Integer id){
        return categoryRepository.findById(id).get();
    }

    public Iterable<CategoryEnt> findAll(){
        return categoryRepository.findAll();
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}