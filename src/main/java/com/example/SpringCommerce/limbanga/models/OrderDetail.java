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
@Table(name = "orderdetails")
public class OrderDetail
        extends BaseModel {
    @ManyToOne
    private Size size;
    private Integer quantity;
    private Double total;

    @ManyToOne
    private Order order;
}
