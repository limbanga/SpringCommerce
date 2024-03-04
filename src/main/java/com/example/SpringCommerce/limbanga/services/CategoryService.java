package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
