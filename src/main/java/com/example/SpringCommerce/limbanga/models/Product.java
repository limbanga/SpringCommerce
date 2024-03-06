package com.example.SpringCommerce.limbanga.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;
    private Double price;
    private String color;

    @ManyToOne
    private Category category;

    @Transient
    private Long categoryId;
}
