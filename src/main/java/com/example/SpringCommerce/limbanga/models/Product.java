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
    @NotEmpty(message = "Product name is required")
    private String name;
    @ManyToOne
    private Category category;
    @Transient // this field for modify actions
    private Long categoryId;
}
