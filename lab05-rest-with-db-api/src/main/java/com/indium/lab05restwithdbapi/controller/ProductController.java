package com.indium.lab05restwithdbapi.controller;

import com.indium.lab05restwithdbapi.entity.Product;
import com.indium.lab05restwithdbapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable String productId) {
        return productService.getProductById(productId).getId();
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        return productService.createProduct(product).getId();
    }
}
