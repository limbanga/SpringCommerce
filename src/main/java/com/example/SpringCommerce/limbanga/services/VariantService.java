package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Variant;
import com.example.SpringCommerce.limbanga.repositories.VariantRepository;
import org.springframework.stereotype.Service;

@Service
public class VariantService
        extends BaseService<Variant,Long> {
    private final VariantRepository variantRepository;
    public VariantService(VariantRepository variantRepository) {
        super(variantRepository);
        this.variantRepository = variantRepository;
    }
}
