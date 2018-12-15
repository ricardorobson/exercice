package com.exercice.practice.repository;

import com.exercice.practice.model.Brand;
import com.exercice.practice.model.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
}