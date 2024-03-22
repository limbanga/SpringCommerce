package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository
        extends BaseRepository<Product, Long>{
    Optional<Product> findBySlugUrl(String slug);
}
