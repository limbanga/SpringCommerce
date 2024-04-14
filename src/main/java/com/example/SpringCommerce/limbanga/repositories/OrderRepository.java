package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
        extends BaseRepository<Order, Long>  {
}
