package com.example.SpringCommerce.limbanga.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_variant__sizes")
public class ProductVariant_Size extends BaseModel {
    @ManyToOne
    private ProductVariant productVariant;
    private ProductSize productSize;
    private Integer stock;
    private Double price;
}
