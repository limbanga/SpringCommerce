package com.example.SpringCommerce.limbanga.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Variant> variants = new ArrayList<>();

    @Transient // this field for modify actions
    private Long categoryId;
}
