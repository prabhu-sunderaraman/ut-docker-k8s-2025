package com.indium.lab03restapi.service;

import com.indium.lab03restapi.entity.Product;
import com.indium.lab03restapi.exception.InsufficientQuantityException;
import com.indium.lab03restapi.exception.ProductNotFoundException;
import com.indium.lab03restapi.repository.ProductRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void instances_are_not_null() {
        assertNotNull(productService);
        assertNotNull(productRepository);
    }

    @Test
    void restock_with_an_unknown_product() {
        when(productRepository.findById("p101")).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> productService.restock("p101", 10));
        verify(productRepository, times(1)).findById("p101");
    }

    @Test
    void sell_with_an_unknown_product() {
        when(productRepository.findById("p101")).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> productService.sell("p101", 10));
        verify(productRepository, times(1)).findById("p101");
    }

    @Test
    void sell_with_quantity_more_than_available() {
        Product initialProduct = new Product();
        initialProduct.setId("p101");
        initialProduct.setQuantity(10);
        when(productRepository.findById("p101")).thenReturn(Optional.of(initialProduct));
        assertThrows(InsufficientQuantityException.class, () -> productService.sell(initialProduct.getId(), 15));
    }

    @Test
    void sell_and_check_quantity() {
        Product initialProduct = new Product();
        initialProduct.setId("p101");
        initialProduct.setQuantity(10);
        when(productRepository.findById("p101")).thenReturn(Optional.of(initialProduct));
        Product modifiedProduct = new Product();
        modifiedProduct.setId("p101");
        modifiedProduct.setQuantity(5);
        when(productRepository.save(initialProduct)).thenReturn(modifiedProduct);
        productService.sell(initialProduct.getId(), 5);
        verify(productRepository, times(1)).findById("p101");
        verify(productRepository, times(1)).save(initialProduct);
    }

    @Test
    void restock_and_check_quantity() {
        Product initialProduct = new Product();
        initialProduct.setId("p101");
        initialProduct.setQuantity(10);
        when(productRepository.findById("p101")).thenReturn(Optional.of(initialProduct));
        Product modifiedProduct = new Product();
        modifiedProduct.setId("p101");
        modifiedProduct.setQuantity(20);
        when(productRepository.save(initialProduct)).thenReturn(modifiedProduct);
        productService.restock(initialProduct.getId(), 10);
        verify(productRepository, times(1)).findById("p101");
        verify(productRepository, times(1)).save(initialProduct);
    }

    @Test
    void get_product_by_id() {
        String productId = "p101";
        Product productToReturn = new Product();
        productToReturn.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(productToReturn));

        Product product = productService.getProductById(productId);
        assertNotNull(product);
        assertEquals(product.getId(), productId);
        verify(productRepository, times(1)).findById(productId);
    }


}
