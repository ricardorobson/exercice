package com.exercice.practice.repository;

import com.exercice.practice.model.CategoryEnt;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEnt, Integer> {
}