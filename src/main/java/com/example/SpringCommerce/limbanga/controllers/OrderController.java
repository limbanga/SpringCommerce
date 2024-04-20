package com.example.SpringCommerce.limbanga.controllers;

import com.example.SpringCommerce.limbanga.appexceptions.CustomValidationException;
import com.example.SpringCommerce.limbanga.models.AppUser;
import com.example.SpringCommerce.limbanga.models.Order;
import com.example.SpringCommerce.limbanga.models.OrderDetail;
import com.example.SpringCommerce.limbanga.models.PaymentStatus;
import com.example.SpringCommerce.limbanga.services.OrderService;
import com.example.SpringCommerce.limbanga.services.SizeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrderController
        extends BaseController<Order, Long> {
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
    public ResponseEntity<Order> getCart(
            @AuthenticationPrincipal AppUser user) {
        return ResponseEntity.ok(orderService.getCart(user.getId()));
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cart/{id}")
    public ResponseEntity<List<OrderDetail>> getCartDetails(
            @AuthenticationPrincipal AppUser user,
            @PathVariable Long id) {
        var cart = orderService.getById(id);
        if (!cart.getId().equals(user.getId())
                || !cart.getPaymentStatus().equals(PaymentStatus.InCart)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(orderService.getCartDetails(id));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cart/{sizeId}/{quantity}")
    public ResponseEntity<OrderDetail> setCartItem(
            @AuthenticationPrincipal AppUser user,
            @PathVariable Long sizeId,
            @PathVariable Integer quantity)
            throws CustomValidationException {
        // todo: test this endpoint

        // check size existed or not
        var size = sizeService.getById(sizeId);
        if (size == null) {
            throw new CustomValidationException("sizeId", "Item not found exist");
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

        // get to update or create or delete new cart detail
        var cartDetail = orderService.getCartDetails(cart.getId()).stream()
                .filter(detail -> detail.getSize().getId().equals(sizeId))
                .findFirst()
                .orElse(null);

        /*
        * REMOVE CART DETAIL CASE
        * */
        // quantity = -1 for remove
        if (quantity <= 0) {
            // remove cart detail if existed
            if (cartDetail != null) {
                orderService.removeCartItem(cartDetail.getId());
            }
            return ResponseEntity.ok().build();
        }

        /*
         * UPDATE CART DETAIL CASE
         * */

        // quantity > 0 for update or create
        // new cart detail if not existed
        if (cartDetail == null) {
            cartDetail = OrderDetail.builder()
                    .order(cart)
                    .size(size)
                    .build();
        }

        cartDetail.setQuantity(quantity);

        return ResponseEntity.ok(orderService.setCartDetail(cartDetail));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/checkout")
    public ResponseEntity<Order> checkout(
            @AuthenticationPrincipal AppUser user) {
        // todo: test this endpoint
        var cart = orderService.getCart(user.getId());
        if (cart == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(orderService.checkout(cart));
    }

}
