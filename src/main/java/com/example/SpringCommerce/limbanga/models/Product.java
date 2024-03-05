package com.example.SpringCommerce.limbanga.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Columns;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseModel {
    private String name;
    private Double price;
    private String color;

    @ManyToOne
    private Category category;

    @Transient
    private Long categoryId;
}
