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
            VariantRepository productVariantRepository,
            SizeRepository _sizeRepository,
            AppUserRepository appUserRepository) {

        return args -> {
            final String SEED_TAG = "Insert:::___";
            // insert category
            var cate = Category.builder()
                    .name("T-Shirt")
                    .build();
            var createdCategory = categoryRepository.save(cate);
            log.info(SEED_TAG + createdCategory);

            // insert product
            var product = Product.builder()
                    .name("Áo Polo Nam 5S Fashion, Cotton USA, Co Giãn 4 Chiều APC23023")
                    .code("APX-3489")
                    .slugUrl("summer-t-shirt-4")
                    .category(createdCategory)
                    .build();

            var createdProduct = productRepository.save(product);
            log.info(SEED_TAG + createdProduct);

            // insert red variant
            var redTShirt = Variant.builder()
                    .image("https://static.nike.com/a/images/t_PDP_17" +
                            "28_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4" +
                            "-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_laye" +
                            "r_apply/1a579b43-1091-46cc-ac48-dd4cd5d8edc6/jorda" +
                            "n-dri-fit-sport-top-CXCRD4.png")
                    .product(createdProduct)
                    .build();

            redTShirt = productVariantRepository.save(redTShirt);
            log.info(SEED_TAG + redTShirt);

            // insert blue variant
            var blueTShirt = Variant.builder()
                    .image("https://th.bing.com/th/id/R.98e331b7d" +
                            "ddebe9ed29656e9af2ae54d?rik=UHjNbMc" +
                            "%2fauE41Q&pid=ImgRaw&r=0")
                    .product(createdProduct)
                    .build();

            blueTShirt = productVariantRepository.save(blueTShirt);
            log.info(SEED_TAG + blueTShirt);

            // insert red size M
            var redTShirtSizeM = Size.builder()
                    .variant(redTShirt)
                    .productSize(ProductSize.M)
                    .price(135_000.0)
                    .stock(50)
                    .build();
            redTShirtSizeM = _sizeRepository.save(redTShirtSizeM);
            log.info(SEED_TAG + redTShirtSizeM);

            // insert red size S
            var redTShirtSizeS = Size.builder()
                    .variant(redTShirt)
                    .productSize(ProductSize.S)
                    .price(99_000.0)
                    .stock(136)
                    .build();
            redTShirtSizeS = _sizeRepository.save(redTShirtSizeS);
            log.info(SEED_TAG + redTShirtSizeS);

            // insert blue variant
            var browTShirt = Variant.builder()
                    .image("https://5sfashion.vn/storage/upload/image" +
                            "s/products/dhkLjeWqJYyD1PqNLSE2gY4qC0VpIXWk3lv0Gjs6.jpg")
                    .product(createdProduct)
                    .build();

            browTShirt = productVariantRepository.save(browTShirt);
            log.info(SEED_TAG + browTShirt);

            // insert admin
            var hashedPassword = passwordEncoder.encode("123456");
            var appUser = AppUser.builder()
                    .username("admin")
                    .password(hashedPassword)
                    .build();
            var createdUser = appUserRepository.save(appUser);
            log.info(SEED_TAG + createdUser);
        };
    }
}
