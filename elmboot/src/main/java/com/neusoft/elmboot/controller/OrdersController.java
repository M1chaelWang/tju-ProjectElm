package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.Orders;
import com.neusoft.elmboot.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/user/{userId}")
    public List<Orders> listOrdersByUserId(@PathVariable("userId") String userId, @RequestHeader("token") String token)
            throws Exception {
        if (securityConfig.isValidToken(token))
            return ordersService.listOrdersByUserId(userId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PostMapping("/create")
    public int createOrders(@RequestBody Orders orders, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return ordersService.createOrders(orders);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @GetMapping("/{orderId}")
    public Orders getOrdersById(@PathVariable("orderId") Integer orderId, @RequestHeader("token") String token)
            throws Exception {
        if (securityConfig.isValidToken(token))
            return ordersService.getOrdersById(orderId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @GetMapping("/update/{orderId}")
    public void updateOrderStateById(@PathVariable("orderId") Integer orderId, @RequestHeader("token") String token)
            throws Exception {
        if (securityConfig.isValidToken(token))
            ordersService.updateOrderStateById(orderId);
        else
            throw new InvalidTokenException("Invalid token");
    }
}
