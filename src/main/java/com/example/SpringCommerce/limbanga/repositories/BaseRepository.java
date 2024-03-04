package com.example.SpringCommerce.limbanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T,ID>
        extends JpaRepository<T, ID> {
    // todo: write more generic logic to DB here
}
