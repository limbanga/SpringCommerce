package com.example.SpringCommerce.limbanga;


import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.repositories.ProductRepository;
import com.example.SpringCommerce.limbanga.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testFindProductBySlug() {
        // Setup mock behavior
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Test Product");
        mockProduct.setSlugUrl("test-product");

        when(productRepository.findBySlugUrl("test-product")).thenReturn(Optional.of(mockProduct));

        // Test the service method
        Product foundProduct = productService.getBySlug("test-product");

        // Assert the result
        assertEquals("Test Product", foundProduct.getName());
    }

}