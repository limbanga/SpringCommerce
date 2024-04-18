package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.models.OrderDetail;
import com.example.SpringCommerce.limbanga.models.PaymentStatus;
import com.example.SpringCommerce.limbanga.services.BaseService;
import com.example.SpringCommerce.limbanga.services.OrderService;
import com.example.SpringCommerce.limbanga.services.SizeService;
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
    private final SizeService sizeService;

    public OrderController(
            OrderService service,
            SizeService sizeService) {
        super(service);
        this.orderService = service;
        this.sizeService = sizeService;
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
        if (!cart.getId().equals(user.getId())
                || !cart.getPaymentStatus().equals(PaymentStatus.InCart)) {
            return null;
        }

        return orderService.getCartDetails(id);
    }

    @GetMapping("/cart/{id}/{productId}/{quantity}")
    public OrderDetail setCartItem(
            @AuthenticationPrincipal AppUser user,
            @PathVariable Long id,
            @PathVariable Long productId,
            @PathVariable Integer quantity) {
        // todo: test this endpoint
        // quantity = -1 for remove
        if (quantity <= 0) {
            return null;
        }

        // check size existed or not
        var size = sizeService.getById(productId);
        if (size == null) {
            return null;
        }

        // get or create cart
        var cart = orderService.getCart(user.getId());
        if (cart == null) {
            cart = Order.builder()
                    .owner(user)
                    .paymentStatus(PaymentStatus.InCart)
                    .build();
            orderService.create(cart);
        }

        // get or create cart detail
        var cartDetail = orderService.getCartDetails(cart.getId()).stream()
                .filter(detail -> detail.getSize().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (cartDetail == null) {
            cartDetail = OrderDetail.builder()
                    .order(cart)
                    .size(size)
                    .build();
        }

        cartDetail.setQuantity(quantity);
        // todo: implement this method

        return orderService.setCartDetail(cartDetail);
    }

}
