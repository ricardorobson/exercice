package com.exercice.practice.service;

import com.exercice.practice.model.Brand;
import com.exercice.practice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand save(@Validated Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand findById(Integer id){
        return brandRepository.findById(id).get();
    }

    public Iterable<Brand> findAll(){
        return brandRepository.findAll();
    }

    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }
}