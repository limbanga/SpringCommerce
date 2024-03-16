package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.ProductVariant_Size;
import com.example.SpringCommerce.limbanga.services.ProductVariant_SizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/product_variant__sizes/")
public class ProductVariant_SizeController
        extends BaseController<ProductVariant_Size, Long> {
    private final ProductVariant_SizeService productVariantSizeService;

    public ProductVariant_SizeController(ProductVariant_SizeService productVariantSizeService) {
        super(productVariantSizeService);
        this.productVariantSizeService = productVariantSizeService;
    }

    // todo: tạo endpoint lấy ra mỗi product 1 sản phẩm duy nhất -> fill cho index page

    @GetMapping("unique")
    public ResponseEntity<List<ProductVariant_Size>> getUniquePerProduct() {
        var returnList = new ArrayList<ProductVariant_Size>();
        var list = productVariantSizeService.getAll();
        // make sure minimum size is taken
        list = list.stream()
                .sorted(Comparator.comparing(ProductVariant_Size::getProductSize))
                .toList();

        list.forEach(x -> {
            var productId = x.getProductVariant().getProduct().getId();
            var isDuplicate = returnList.stream()
                    .anyMatch(y -> {
                        var productIdIn = y.getProductVariant().getProduct().getId();
                        return productId.equals(productIdIn);
                    });
            if (!isDuplicate) {
                returnList.add(x);
            }
        });

        return ResponseEntity.ok(returnList);
    }
}
