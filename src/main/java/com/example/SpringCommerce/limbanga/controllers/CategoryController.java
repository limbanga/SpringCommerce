package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories/")
public class CategoryController extends BaseController<Category, Long>{
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

}
