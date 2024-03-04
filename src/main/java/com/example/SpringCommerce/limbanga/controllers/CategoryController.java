package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.services.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products/")
public class CategoryController extends BaseController<Category, Long>{
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }


}
