package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {

}
