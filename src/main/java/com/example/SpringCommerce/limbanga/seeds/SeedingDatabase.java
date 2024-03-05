package com.example.SpringCommerce.limbanga.seeds;

import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.repositories.CategoryRepository;
import com.example.SpringCommerce.limbanga.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class SeedingDatabase {
    private static final Logger log = LoggerFactory.getLogger(SeedingDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {

        return args -> {
            var cate = Category.builder()
                    .name("Seeding name")
                    .build();
            var createdCate =  categoryRepository.save(cate);
            log.info("Preloading " + createdCate);

            var product = Product.builder()
                    .name("Seed product")
                    .price(999.0)
                    .color("red")
                    .build();

            var createdProduct = productRepository.save(product);
            log.info("Preloading " + createdProduct);
        };
    }
}
