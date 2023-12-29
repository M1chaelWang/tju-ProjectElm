package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.DeliveryAddress;
import com.neusoft.elmboot.service.DeliveryAddressService;

@RestController
@RequestMapping("/deliveryAddresses")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/user/{userId}")
    public List<DeliveryAddress> listDeliveryAddressByUserId(@PathVariable("userId") String userId,
            @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return deliveryAddressService.listDeliveryAddressByUserId(userId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @GetMapping("/{daId}")
    public DeliveryAddress getDeliveryAddressById(@PathVariable("daId") Integer daId,
            @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return deliveryAddressService.getDeliveryAddressById(daId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PostMapping("/add")
    public int saveDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress, @RequestHeader("token") String token)
            throws Exception {
        if (securityConfig.isValidToken(token))
            return deliveryAddressService.saveDeliveryAddress(deliveryAddress);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PutMapping("/update")
    public int updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress, @RequestHeader("token") String token)
            throws Exception {
        if (securityConfig.isValidToken(token))
            return deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @DeleteMapping("/{daId}")
    public int removeDeliveryAddress(@PathVariable("daId") Integer daId, @RequestHeader("token") String token)
            throws Exception {
        if (securityConfig.isValidToken(token))
            return deliveryAddressService.removeDeliveryAddress(daId);
        else
            throw new InvalidTokenException("Invalid token");
    }
}
