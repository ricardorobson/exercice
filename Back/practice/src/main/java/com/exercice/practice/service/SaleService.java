package com.exercice.practice.service;

import com.exercice.practice.model.Sale;
import com.exercice.practice.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Sale save(@Validated Sale sale) {
        return saleRepository.save(sale);
    }


    public List<Sale> findByAttrs(Integer idCategory, Integer idProduct, Integer idBrand) {
        return saleRepository.findByAttrs(idCategory, idProduct, idBrand);
    }
    public Sale findById(Integer id){
        return saleRepository.findById(id).get();
    }

    public Iterable<Sale> findAll(){
        return saleRepository.findAll();
    }

    public void delete(Integer id) {
        saleRepository.deleteById(id);
    }
}