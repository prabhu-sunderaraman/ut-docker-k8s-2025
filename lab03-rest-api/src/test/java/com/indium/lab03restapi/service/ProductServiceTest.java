package com.indium.lab03restapi.service;

import com.indium.lab03restapi.entity.Product;
import com.indium.lab03restapi.repository.ProductRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void get_product_by_id() {
        String productId = "p101";
        Product productToReturn = new Product();
        productToReturn.setId(productId);
        when(productRepository.findById(productId)).thenReturn(productToReturn);

        Product product = productService.getProductById(productId);
        assertNotNull(product);
        assertEquals(product.getId(), productId);
        verify(productRepository, times(1)).findById(productId);
    }
}
