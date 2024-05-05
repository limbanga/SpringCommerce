package com.example.SpringCommerce.limbanga.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order extends BaseModel {
    @ManyToOne
    private AppUser owner;

    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    private Double totalPay;
    private PaymentStatus paymentStatus;
    private LocalDateTime shippingDate;
    private LocalDateTime arriveDate;
}

