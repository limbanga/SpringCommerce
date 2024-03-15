package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.ProductVariant_Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariant_SizeRepository
        extends JpaRepository<ProductVariant_Size, Long> {
}
