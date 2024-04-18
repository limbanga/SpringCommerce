package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.models.OrderDetail;
import com.example.SpringCommerce.limbanga.models.PaymentStatus;
import com.example.SpringCommerce.limbanga.repositories.OrderDetailRepository;
import com.example.SpringCommerce.limbanga.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
        extends BaseService<Order, Long> {

    private final OrderRepository repository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(
            OrderRepository repository,
            OrderDetailRepository orderDetailRepository) {
        super(repository);
        this.repository = repository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Order getCart(Long ownerId) {
        return repository.findAll().stream()
                .filter(order -> order.getOwner().getId().equals(ownerId))
                .filter(order -> order.getPaymentStatus().equals(PaymentStatus.InCart))
                .findFirst()
                .orElse(null);
    }

    public List<OrderDetail> getCartDetails(Long id) {
        return orderDetailRepository.findByOrderId(id);
    }
}
