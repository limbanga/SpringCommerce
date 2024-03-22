package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.ProductVariant;
import com.example.SpringCommerce.limbanga.repositories.ProductVariantRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantService
        extends BaseService<ProductVariant,Long> {
    private final ProductVariantRepository productVariantRepository;
    public ProductVariantService(ProductVariantRepository productVariantRepository) {
        super(productVariantRepository);
        this.productVariantRepository = productVariantRepository;
    }
}
