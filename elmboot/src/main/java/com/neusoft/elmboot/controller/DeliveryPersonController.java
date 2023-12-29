package com.neusoft.elmboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.DeliveryPerson;
import com.neusoft.elmboot.service.DeliveryPersonService;

@RestController
@RequestMapping("/deliveryPerson")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/{personId}")
    public DeliveryPerson getDeliveryPersonById(@PathVariable("personId") Integer personId, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return deliveryPersonService.getDeliveryPersonById(personId);
        else
            throw new InvalidTokenException("Invalid token");
    }
}
