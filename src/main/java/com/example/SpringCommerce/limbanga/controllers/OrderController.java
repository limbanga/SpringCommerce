package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.services.BaseService;
import com.example.SpringCommerce.limbanga.services.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
