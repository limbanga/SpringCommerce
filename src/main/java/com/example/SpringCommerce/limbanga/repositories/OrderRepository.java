package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.models.PaymentStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository
        extends BaseRepository<Order, Long>  {
    List<Order> findByOwnerId(Long ownerId);
}
