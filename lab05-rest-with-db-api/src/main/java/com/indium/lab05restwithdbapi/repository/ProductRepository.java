package com.indium.lab05restwithdbapi.repository;

import com.indium.lab05restwithdbapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
