package com.exercice.practice.service;

import com.exercice.practice.model.Product;
import com.exercice.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(@Validated Product product) {
        return productRepository.save(product);
    }

    public Product findById(Integer id){
        return productRepository.findById(id).get();
    }

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}