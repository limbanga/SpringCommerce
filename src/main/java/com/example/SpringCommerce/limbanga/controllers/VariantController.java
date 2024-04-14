package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.appexceptions.CustomValidationException;
import com.example.SpringCommerce.limbanga.models.ProductSize;
import com.example.SpringCommerce.limbanga.models.Size;
import com.example.SpringCommerce.limbanga.models.Variant;
import com.example.SpringCommerce.limbanga.services.SizeService;
import com.example.SpringCommerce.limbanga.services.VariantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/variants/")
public class VariantController
        extends BaseController<Variant, Long> {
    private final VariantService variantService;
    private final SizeService sizeService;

    public VariantController(VariantService variantService, SizeService sizeService) {
        super(variantService);
        this.variantService = variantService;
        this.sizeService = sizeService;
    }

    @GetMapping("/filter-by")
    public List<Variant> filterBy(
            @RequestParam(value = "productId", required = false) Long productId) {
        // all record
        var list = variantService.getAll();
        // filter base condition
        if (productId != null) {
            list = list.stream().filter(x -> x.getProduct().getId().equals(productId)).toList();
        }
        return list;
    }

    @Override
    public ResponseEntity<Variant> create(Variant body)
            throws CustomValidationException {
        var variant = super.create(body).getBody();

        for (ProductSize size : ProductSize.values()) {
            // 6 size
            var variantWithSize = Size.builder()
                    .productSize(size)
                    .price(0.0)
                    .stock(0)
                    .variant(body)
                    .isActive(false)
                    .build();

            sizeService.create(variantWithSize);
        }

        assert variant != null;
        return ResponseEntity.created(URI.create("/variants/" + variant.getId())).body(variant);
    }
}
