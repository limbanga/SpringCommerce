package com.example.SpringCommerce.limbanga.seeds;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class SeedingDatabase {
    private static final Logger log = LoggerFactory.getLogger(SeedingDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository) {

        return args -> {
            var cate = Category.builder()
                    .name("Seeding name")
                    .build();
            log.info("Preloading " + categoryRepository.save(cate));
        };
    }
}
