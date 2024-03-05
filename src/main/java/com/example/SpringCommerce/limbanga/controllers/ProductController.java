package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/")
public class ProductController
        extends BaseController<Product, Long> {
    private final ProductService productService;
    public ProductController( ProductService productService) {
        super(productService);
        this.productService = productService;
    }
}
