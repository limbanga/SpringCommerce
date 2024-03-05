package com.example.SpringCommerce.limbanga.models;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends BaseModel {
    private String name;
    private Double price;
    private String color;
}
