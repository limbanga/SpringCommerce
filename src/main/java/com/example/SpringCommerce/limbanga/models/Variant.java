package com.example.SpringCommerce.limbanga.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "variants")
public class Variant extends BaseModel {
    @ManyToOne
    private Product product;

    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "variant", orphanRemoval = true)
    private List<Size> _sizes;
}
