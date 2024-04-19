package com.example.SpringCommerce.limbanga.repositories;

import com.example.SpringCommerce.limbanga.models.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository
        extends BaseRepository<OrderDetail, Long>{
    List<OrderDetail> findByOrderId(Long id);

}
