package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.BaseModel;
import com.example.SpringCommerce.limbanga.repositories.BaseRepository;

import java.util.List;

public abstract class BaseService<T extends BaseModel, ID> {

    protected BaseRepository<T, ID> repository;

    public BaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public T create(T model) {
        return repository.save(model);
    }

    public T update(ID id, T model) {
        // didn't match case
        if (!id.equals(model.getId())) {
            return null;
        }
        return repository.save(model);
    }

    public void delete(T model) {
        repository.delete(model);
    }

    public void deleteById(ID id) {
        var model = getById(id);
        if (model != null) {
            repository.delete(model);
        }
    }
}
