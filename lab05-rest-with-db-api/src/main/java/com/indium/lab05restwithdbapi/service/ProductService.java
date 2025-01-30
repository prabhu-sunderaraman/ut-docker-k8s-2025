package com.indium.lab05restwithdbapi.service;

import com.indium.lab05restwithdbapi.entity.Product;
import com.indium.lab05restwithdbapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
