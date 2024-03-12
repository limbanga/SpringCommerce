package com.example.SpringCommerce.limbanga.seeds;

import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.models.Category;
import com.example.SpringCommerce.limbanga.models.Product;
import com.example.SpringCommerce.limbanga.repositories.AppUserRepository;
import com.example.SpringCommerce.limbanga.repositories.CategoryRepository;
import com.example.SpringCommerce.limbanga.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
class SeedingDatabase {
    private static final Logger log = LoggerFactory.getLogger(SeedingDatabase.class);
    private final PasswordEncoder passwordEncoder;

    SeedingDatabase(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initDatabase (
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            AppUserRepository appUserRepository) {

        return args -> {
            var cate = Category.builder()
                    .name("Seeding name")
                    .build();
            var createdCategory =  categoryRepository.save(cate);
            log.info("Preloading " + createdCategory);

            var product = Product.builder()
                    .name("Seed product")
                    .category(createdCategory)
                    .build();

            var createdProduct = productRepository.save(product);
            log.info("Preloading " + createdProduct);


            var hashpass = passwordEncoder.encode("123456");
            var appUser = AppUser.builder()
                    .username("admin")
                    .password(hashpass)
                    .build();

            var createdUser = appUserRepository.save(appUser);
            log.info("Preloading " + createdUser);
        };
    }
}
