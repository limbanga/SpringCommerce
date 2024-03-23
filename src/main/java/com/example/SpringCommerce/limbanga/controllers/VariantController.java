package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.ProductVariant;
import com.example.SpringCommerce.limbanga.services.ProductVariantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/variants/")
public class VariantController
        extends BaseController<ProductVariant, Long> {
    private final ProductVariantService productVariantService;
    public VariantController(ProductVariantService productVariantService) {
        super(productVariantService);
        this.productVariantService = productVariantService;
    }

    @GetMapping("/filter-by")
    public List<ProductVariant> filterBy(
            @RequestParam(value = "productId", required = false) Long productId) {
        // all record
        var list = productVariantService.getAll();
        // filter base condition
        if (productId != null) {
            list = list.stream().filter(x -> x.getProduct().getId().equals(productId)).toList();
        }
        return list;
    }
}
