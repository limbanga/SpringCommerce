package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Size;
import com.example.SpringCommerce.limbanga.repositories.SizeRepository;
import org.springframework.stereotype.Service;

@Service
public class SizeService
        extends BaseService<Size, Long> {
    private final SizeRepository repository;
    public SizeService(SizeRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
