package com.exercice.practice.repository;

import com.exercice.practice.model.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
}