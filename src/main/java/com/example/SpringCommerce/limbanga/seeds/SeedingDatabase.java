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

            /*
            * Insert product 1
            * */
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
                    .image("https://5sfashion.vn/storage/upload/images/products/AXQqO1801Bosg6zR2iEzBzxPeaUxamZBViI8jq3N.jpg")
                    .product(createdProduct)
                    .build();

            redTShirt = productVariantRepository.save(redTShirt);
            log.info(SEED_TAG + redTShirt);

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
            var blueTShirt = Variant.builder()
                    .image("https://5sfashion.vn/storage/upload/images/products/lwHFmO9X83EoH8ZXGa1qb3YYFBuEZ33nyl9JIiYw.jpg")
                    .product(createdProduct)
                    .build();

            blueTShirt = productVariantRepository.save(blueTShirt);
            log.info(SEED_TAG + blueTShirt);

            // insert blue size M
            var blueTShirtSizeM = Size.builder()
                    .variant(blueTShirt)
                    .productSize(ProductSize.M)
                    .price(155_000.0)
                    .stock(13)
                    .build();
            blueTShirtSizeM = _sizeRepository.save(blueTShirtSizeM);
            log.info(SEED_TAG + blueTShirtSizeM);

            // insert brown variant
            var browTShirt = Variant.builder()
                    .image("https://5sfashion.vn/storage/upload/images/products/8Bn129RaAk0Ca6cDcFBhHR2D8QhpHH3oZjzKzu3P.jpg")
                    .product(createdProduct)
                    .build();

            browTShirt = productVariantRepository.save(browTShirt);
            log.info(SEED_TAG + browTShirt);


            // insert brow size M
            var browTShirtSizeM = Size.builder()
                    .variant(browTShirt)
                    .productSize(ProductSize.M)
                    .price(125_000.0)
                    .stock(100)
                    .build();
            browTShirtSizeM = _sizeRepository.save(browTShirtSizeM);
            log.info(SEED_TAG + browTShirtSizeM);

            // insert brow size L
            var browTShirtSizeL = Size.builder()
                    .variant(browTShirt)
                    .productSize(ProductSize.L)
                    .price(165_000.0)
                    .stock(100)
                    .build();
            browTShirtSizeL = _sizeRepository.save(browTShirtSizeL);
            log.info(SEED_TAG + browTShirtSizeL);

            /*
             * End insert product 1
             * */


            /*
             * Insert product 2
             * */
            var product2 = Product.builder()
                    .name("Áo Polo Nam 5S Fashion, Vải Silk Cao Cấp, Mềm Mại, Nhẹ Mát APC23061")
                    .code("APC23061")
                    .slugUrl("summer-t-shirt-APC23061")
                    .category(createdCategory)
                    .build();

            product2 = productRepository.save(product2);
            log.info(SEED_TAG + product2);

            // insert pink variant
            var pinkTShirt2 = Variant.builder()
                    .image("https://5sfashion.vn/storage/upload/images/products/Ll14OEjr536IHYKgjq8RC1gDRQBdpDJ4LkfWK2n7.jpg")
                    .product(product2)
                    .build();

            pinkTShirt2 = productVariantRepository.save(pinkTShirt2);
            log.info(SEED_TAG + pinkTShirt2);

            // insert pink size S
            var pinkTShirtSizeS2 = Size.builder()
                    .variant(pinkTShirt2)
                    .productSize(ProductSize.M)
                    .price(155_000.0)
                    .stock(55)
                    .build();
            pinkTShirtSizeS2 = _sizeRepository.save(pinkTShirtSizeS2);
            log.info(SEED_TAG + pinkTShirtSizeS2);

            // insert pink size M
            var pinkTShirtSizeM2 = Size.builder()
                    .variant(pinkTShirt2)
                    .productSize(ProductSize.M)
                    .price(175_000.0)
                    .stock(20)
                    .build();
            pinkTShirtSizeM2 = _sizeRepository.save(pinkTShirtSizeM2);
            log.info(SEED_TAG + pinkTShirtSizeM2);

            // insert black variant
            var blackTShirt2 = Variant.builder()
                    .image("https://5sfashion.vn/storage/upload/images/products/YHSE7o5wY45nuc6Bl7Zkoa7XrCeIRkOkKFNbM1h2.jpg")
                    .product(product2)
                    .build();

            blackTShirt2 = productVariantRepository.save(blackTShirt2);
            log.info(SEED_TAG + blackTShirt2);

            // insert blue size M
            var blackTShirtSizeM2 = Size.builder()
                    .variant(blackTShirt2)
                    .productSize(ProductSize.M)
                    .price(255_000.0)
                    .stock(13)
                    .build();
            blackTShirtSizeM2 = _sizeRepository.save(blackTShirtSizeM2);
            log.info(SEED_TAG + blackTShirtSizeM2);

            // insert brown variant
            var orangeTShirt2 = Variant.builder()
                    .image("https://5sfashion.vn/storage/upload/images/products/smrtlesroOkFwkYj6cYmpzCkHstRXKXPd90C7iIF.jpg")
                    .product(product2)
                    .build();

            orangeTShirt2 = productVariantRepository.save(orangeTShirt2);
            log.info(SEED_TAG + orangeTShirt2);


            // insert orange size M
            var orangeTShirtSizeM = Size.builder()
                    .variant(orangeTShirt2)
                    .productSize(ProductSize.M)
                    .price(125_000.0)
                    .stock(100)
                    .build();
            orangeTShirtSizeM = _sizeRepository.save(orangeTShirtSizeM);
            log.info(SEED_TAG + orangeTShirtSizeM);

            // insert brow size L
            var orangeTShirtSizeL = Size.builder()
                    .variant(orangeTShirt2)
                    .productSize(ProductSize.L)
                    .price(165_000.0)
                    .stock(100)
                    .build();
            orangeTShirtSizeL = _sizeRepository.save(orangeTShirtSizeL);
            log.info(SEED_TAG + orangeTShirtSizeL);

            /*
             * End insert product 2
             * */


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
