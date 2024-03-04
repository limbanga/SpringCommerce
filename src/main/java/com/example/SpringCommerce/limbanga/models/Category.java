package com.example.SpringCommerce.limbanga.models;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category extends BaseModel {
    private String name;
}
