package com.indium.lab03restapi.repository;

import com.indium.lab03restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
