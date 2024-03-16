package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.ProductVariant_Size;
import com.example.SpringCommerce.limbanga.repositories.ProductVariant_SizeRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductVariant_SizeService
        extends BaseService<ProductVariant_Size, Long> {
    private final ProductVariant_SizeRepository repository;
    public ProductVariant_SizeService( ProductVariant_SizeRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
