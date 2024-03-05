package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.services.CategoryService;
import com.example.SpringCommerce.limbanga.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/")
public class ProductController
        extends BaseController<Product, Long> {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(
            ProductService productService,
            CategoryService categoryService) {
        super(productService);
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Product> create(Product body) {
        var category = categoryService.getById(body.getCategoryId());
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }
        body.setCategory(category);
        return super.create(body);
    }

    @Override
    public ResponseEntity<Product> update(Long id, Product body) {

        if (body.getCategoryId() == null) {
            return ResponseEntity.badRequest().build();
        }

        var category = categoryService.getById(body.getCategoryId());

        if (category == null) {
            return ResponseEntity.badRequest().build();
        }

        body.setCategory(category);

        return super.update(id, body);
    }

}
