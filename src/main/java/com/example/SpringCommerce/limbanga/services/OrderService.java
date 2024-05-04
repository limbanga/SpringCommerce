package com.example.SpringCommerce.limbanga.services;

import com.example.SpringCommerce.limbanga.models.AppUser;
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

    public OrderDetail setCartDetail(OrderDetail cartDetail) {
        return orderDetailRepository.save(cartDetail);
    }

    public void removeCartItem(Long id) {
        orderDetailRepository.deleteById(id);
    }

    public Order checkout(Order cart) {
        /*
        *   UPDATE CART STATUS
        * */
        cart.setPaymentStatus(PaymentStatus.Pending);
        var today = java.time.LocalDateTime.now();
        cart.setShippingDate(today);
        cart.setArriveDate(today.plusDays(7));

        /*
        * CALCULATE TOTAL PAY
        * */
        var orderDetails = getCartDetails(cart.getId());
        var total = 0.0;
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setTotal(orderDetail.getSize().getPrice() * orderDetail.getQuantity());
            total += orderDetail.getTotal();
            orderDetailRepository.save(orderDetail);
        }

        cart.setTotalPay(total);

        return repository.save(cart);
    }

    public List<Order> getOrderByOwner(Long ownerId) {

        return repository.findByOwnerId(ownerId);
    }
}
