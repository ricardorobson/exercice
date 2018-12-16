package com.exercice.practice.repository;

import com.exercice.practice.model.Brand;
import com.exercice.practice.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
    @Query("SELECT g FROM Sale g WHERE id_category = :idCategory AND id_product = :idProduct AND id_brand = :idBrand")
    List<Sale> findByAttrs(@Param("idCategory") long idCategory, @Param("idProduct") long idProduct, @Param("idBrand") long idBrand);
}