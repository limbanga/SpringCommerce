package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
