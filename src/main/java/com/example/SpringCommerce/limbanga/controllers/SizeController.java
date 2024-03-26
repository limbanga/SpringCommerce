package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.Size;
import com.example.SpringCommerce.limbanga.services.SizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/sizes/")
public class SizeController
        extends BaseController<Size, Long> {
    private final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        super(sizeService);
        this.sizeService = sizeService;
    }

    // endpoint lấy ra mỗi product 1 sản phẩm duy nhất -> fill cho index page
    @GetMapping("unique")
    public ResponseEntity<List<Size>> getUniquePerProduct() {
        var returnList = new ArrayList<Size>();
        var list = sizeService.getAll();
        // make sure minimum size is taken
        list = list.stream()
                .sorted(Comparator.comparing(Size::getProductSize))
                .toList();

        list.forEach(x -> {
            var productId = x.getVariant().getProduct().getId();
            var isDuplicate = returnList.stream()
                    .anyMatch(y -> {
                        var productIdIn = y.getVariant().getProduct().getId();
                        return productId.equals(productIdIn);
                    });
            if (!isDuplicate) {
                returnList.add(x);
            }
        });

        return ResponseEntity.ok(returnList);
    }

    @GetMapping("filter-by")
    public ResponseEntity<List<Size>> filterBy(
            @RequestParam(value = "variantId", required = false) Long variantId) {
        var list = sizeService.getAll();
        if (variantId != null) {
            list = list.stream().filter(x -> x.getVariant().getId().equals(variantId)).toList();
        }

        list = list.stream().sorted(Comparator.comparing(Size::getProductSize)).toList();
        return ResponseEntity.ok(list);
    }
}
