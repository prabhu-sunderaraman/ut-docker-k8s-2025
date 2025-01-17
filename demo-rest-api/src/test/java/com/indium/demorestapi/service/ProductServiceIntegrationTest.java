package com.indium.demorestapi.service;

import com.indium.demorestapi.entity.Product;
import com.indium.demorestapi.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.*;

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
    public static void setup() {
        mySQLContainer.start();
    }

    @AfterAll
    public static void tearDown() {
        mySQLContainer.stop();
    }

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @BeforeEach
    void initializeProducts() {
        Product product = new Product();
        product.setId("p101");
        productRepository.save(product);
    }

    @AfterEach
    void cleanupProducts() {
        productRepository.deleteAll();
    }

    @Test
    void get_product_by_id() {
        Product product = productService.getProductById("p101");
        assertNotNull(product);
        assertEquals(product.getId(), "p101");
    }
}

