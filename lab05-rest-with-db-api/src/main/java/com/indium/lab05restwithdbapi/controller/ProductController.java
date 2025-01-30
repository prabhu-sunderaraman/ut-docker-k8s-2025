package com.indium.lab05restwithdbapi.controller;

import com.indium.lab05restwithdbapi.entity.Product;
import com.indium.lab05restwithdbapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public String getProductById(String productId) {
        return productService.getProductById(productId).getId();
    }

    @PostMapping
    public String createProduct(Product product) {
        return productService.createProduct(product).getId();
    }
}
