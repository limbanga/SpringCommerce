package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.BaseModel;
import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        var model = service.getById(id);
        if (model == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(model);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T body) {
        var model = service.create(body);

        if (model == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(model);
    }

    @PutMapping("{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T body) {
        var model = service.getById(id);
        if (model == null) {
            return ResponseEntity.notFound().build();
        }

        var updatedModel = service.update(id, body);
        if (updatedModel == null) {
            // todo: write message detail for id field
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(updatedModel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
