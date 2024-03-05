package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends BaseRepository<Product, Long>{
}
