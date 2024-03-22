package com.example.SpringCommerce.limbanga.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseModel {
    @NotEmpty(message = "Product name is required")
    private String name;
    private String code;
    private String slugUrl;
    @ManyToOne
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductVariant> productVariants;

    @Transient // this field for modify actions
    private Long categoryId;
}
