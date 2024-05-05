package com.example.SpringCommerce.limbanga.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
