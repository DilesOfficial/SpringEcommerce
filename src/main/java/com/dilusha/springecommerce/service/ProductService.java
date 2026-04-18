package com.dilusha.springecommerce.service;

import com.dilusha.springecommerce.model.Product;
import com.dilusha.springecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    };
}
