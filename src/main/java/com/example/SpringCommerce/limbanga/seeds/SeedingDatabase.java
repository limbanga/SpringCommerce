package com.example.SpringCommerce.limbanga.seeds;

import com.example.SpringCommerce.limbanga.models.*;
import com.example.SpringCommerce.limbanga.repositories.*;
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
    CommandLineRunner initDatabase(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            ProductVariantRepository productVariantRepository,
            ProductVariant_SizeRepository productVariant_sizeRepository,
            AppUserRepository appUserRepository) {

        return args -> {
            final String SEED_TAG = "Insert>>";

            var cate = Category.builder()
                    .name("T-Shirt")
                    .build();
            var createdCategory = categoryRepository.save(cate);
            log.info("Preloading " + createdCategory);

            var product = Product.builder()
                    .name("Summer T-Shirt")
                    .code("APX-3489")
                    .category(createdCategory)
                    .build();

            var createdProduct = productRepository.save(product);
            log.info("Preloading " + createdProduct);

            var redTShirt = ProductVariant.builder()
                    .image("https://static.nike.com/a/images/t_PDP_17" +
                            "28_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4" +
                            "-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_laye" +
                            "r_apply/1a579b43-1091-46cc-ac48-dd4cd5d8edc6/jorda" +
                            "n-dri-fit-sport-top-CXCRD4.png")
                    .product(createdProduct)
                    .build();

            redTShirt = productVariantRepository.save(redTShirt);
            log.info(SEED_TAG + redTShirt);

            var redTShirtSizeS = ProductVariant_Size.builder()
                    .productVariant(redTShirt)
                    .productSize(ProductSize.SIZE_S)
                    .price(99_000.0)
                    .stock(136)
                    .build();

            redTShirtSizeS = productVariant_sizeRepository.save(redTShirtSizeS);
            log.info(SEED_TAG + redTShirtSizeS);

            var hashedPassword = passwordEncoder.encode("123456");
            var appUser = AppUser.builder()
                    .username("admin")
                    .password(hashedPassword)
                    .build();

            var createdUser = appUserRepository.save(appUser);
            log.info("Preloading " + createdUser);
        };
    }
}
