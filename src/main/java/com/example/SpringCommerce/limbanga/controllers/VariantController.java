package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.appexceptions.CustomValidationException;
import com.example.SpringCommerce.limbanga.models.Variant;
import com.example.SpringCommerce.limbanga.services.VariantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/variants/")
public class VariantController
        extends BaseController<Variant, Long> {
    private final VariantService variantService;
    public VariantController(VariantService variantService) {
        super(variantService);
        this.variantService = variantService;
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
    public ResponseEntity<Variant> create(Variant body) throws CustomValidationException {
        // TODO: Create new variant and 6 sizes
        return super.create(body);
    }
}
