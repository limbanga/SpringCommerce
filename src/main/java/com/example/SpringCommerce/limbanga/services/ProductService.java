package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService
        extends BaseService<Product, Long> {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public Product getBySlug(String slug) {
        return productRepository.findBySlugUrl(slug).orElse(null);
    }
}
