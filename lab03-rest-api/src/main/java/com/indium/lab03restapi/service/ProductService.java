package com.indium.lab03restapi.service;

import com.indium.lab03restapi.entity.Product;
import com.indium.lab03restapi.exception.InsufficientQuantityException;
import com.indium.lab03restapi.exception.ProductNotFoundException;
import com.indium.lab03restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.get();
    }

    public void restock(String id, int quantity) {
        Product product = getProductInstance(id);
        product.setQuantity(product.getQuantity() + quantity);
        productRepository.save(product);
    }

    private Product getProductInstance(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        Product product = optionalProduct.get();
        return product;
    }

    public void sell(String id, int quantity) {
        Product product = getProductInstance(id);
        if (product.getQuantity() < quantity) {
            throw new InsufficientQuantityException(id);
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }
}
