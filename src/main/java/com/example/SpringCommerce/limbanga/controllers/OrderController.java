package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.models.OrderDetail;
import com.example.SpringCommerce.limbanga.models.PaymentStatus;
import com.example.SpringCommerce.limbanga.services.BaseService;
import com.example.SpringCommerce.limbanga.services.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrderController extends BaseController<Order, Long> {
    private final OrderService orderService;

    public OrderController( OrderService service) {
        super(service);
        this.orderService = service;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cart")
    public Order getCart(@AuthenticationPrincipal AppUser user) {
        return orderService.getCart(user.getId());
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cart/{id}")
    public List<OrderDetail> getCartDetails(
            @AuthenticationPrincipal AppUser user,
            @PathVariable Long id) {
        var cart = orderService.getById(id);
        if (!cart.getId().equals(user.getId()) || !cart.getPaymentStatus().equals(PaymentStatus.InCart)) {
            return null;
        }

        return orderService.getCartDetails(id);
    }
}
