package com.ms.order.controller;

import com.ms.order.dto.OrderRequest;
import com.ms.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}