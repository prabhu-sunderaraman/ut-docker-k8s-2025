package com.indium.lab03restapi.repository;

import com.indium.lab03restapi.entity.Product;

public interface ProductRepository {
    Product findById(String productId);
}
