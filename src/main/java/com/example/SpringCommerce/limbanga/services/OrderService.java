package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.models.PaymentStatus;
import com.example.SpringCommerce.limbanga.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService
        extends BaseService<Order, Long> {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Order getCart(Long ownerId) {
        return repository.findAll().stream()
                .filter(order -> order.getOwner().getId().equals(ownerId))
                .filter(order -> order.getPaymentStatus().equals(PaymentStatus.InCart))
                .findFirst()
                .orElse(null);
    }
}
