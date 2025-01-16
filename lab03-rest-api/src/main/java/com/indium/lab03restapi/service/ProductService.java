package com.indium.lab03restapi.service;

import com.indium.lab03restapi.entity.Product;
import com.indium.lab03restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String productId) {
        return productRepository.findById(productId);
    }
}
