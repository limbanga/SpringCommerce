package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.BaseModel;
import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.services.BaseService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public abstract class BaseController<T extends BaseModel, ID> {

    protected BaseService<T, ID> service;

    public BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }


}
