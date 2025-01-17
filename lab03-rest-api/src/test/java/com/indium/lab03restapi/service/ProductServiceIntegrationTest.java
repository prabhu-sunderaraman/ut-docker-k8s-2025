package com.indium.lab03restapi.service;

import com.indium.lab03restapi.entity.Product;
import com.indium.lab03restapi.exception.InsufficientQuantityException;
import com.indium.lab03restapi.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
public class ProductServiceIntegrationTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:5.7")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @BeforeAll
    static void initializeDb() {
        mySQLContainer.start();
    }

    @AfterAll
    static void cleanupDb() {
        mySQLContainer.stop();
    }

    @DynamicPropertySource
    static void initializeDbProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }


    @Test
    void instances_are_not_null() {
        assertNotNull(productService);
        assertNotNull(productRepository);
    }

    @BeforeEach
    void createProducts() {
        String productId = "p101";
        Product product = new Product();
        product.setId(productId);
        product.setQuantity(10);
        productRepository.save(product); //save this to the actual DB
    }

    @AfterEach
    void deleteProducts() {
        productRepository.deleteAll();
    }

    @Test
    void restock_and_check_quantity() {
        productService.restock("p101", 10);
        Product product = productRepository.findById("p101").get();
        assertEquals(product.getQuantity(), 20);
    }

    @Test
    void sell_and_check_quantity() {
        productService.sell("p101", 5);
        Product product = productRepository.findById("p101").get();
        assertEquals(product.getQuantity(), 5);
    }

    @Test
    void sell_with_quantity_more_than_available() {
        assertThrows(InsufficientQuantityException.class, () -> productService.sell("p101", 15));
    }


    @Test
    void get_product_by_id() {
        String productId = "p101";
        Product product = productService.getProductById(productId);
        assertNotNull(product);
        assertEquals(product.getId(), productId);
    }
}
