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
@Table(name = "sizes")
public class Size extends BaseModel {
    @ManyToOne
    private Variant variant;
    private ProductSize productSize;
    private Integer stock;
    private Double price;
    private Boolean isActive = false;
}
