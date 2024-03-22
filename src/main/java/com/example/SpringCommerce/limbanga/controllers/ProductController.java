package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.helpers.SlugHelper;
import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.services.CategoryService;
import com.example.SpringCommerce.limbanga.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

        String slug = SlugHelper.createSlug(body.getName()+ body.getCode());
        body.setSlugUrl(slug);

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

    @GetMapping("slug/{slug}")
    public ResponseEntity<Product> getBySlug(@PathVariable String slug) {
        var product = productService.getBySlug(slug);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}
