package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.ProductVariant;
import com.example.SpringCommerce.limbanga.services.BaseService;
import com.example.SpringCommerce.limbanga.services.ProductVariantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/variants/")
public class VariantController
        extends BaseController<ProductVariant, Long> {
    private final ProductVariantService productVariantService;
    public VariantController(ProductVariantService productVariantService) {
        super(productVariantService);
        this.productVariantService = productVariantService;
    }

}
