package com.indium.demorestapi.service;

import com.indium.demorestapi.entity.Product;
import com.indium.demorestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }
}
