package com.example.SpringCommerce.limbanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface BaseRepository<T,ID>
        extends JpaRepository<T, ID> {
    // todo: write more generic logic to DB here
}
