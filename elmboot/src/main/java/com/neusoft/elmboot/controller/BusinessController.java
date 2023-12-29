package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.Business;
import com.neusoft.elmboot.service.BusinessService;

@RestController
@RequestMapping("/businesses")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/orderType/{orderTypeId}")
    public List<Business> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return businessService.listBusinessByOrderTypeId(orderTypeId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @GetMapping("/{businessId}")
    public Business getBusinessById(@PathVariable("businessId") Integer businessId, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return businessService.getBusinessById(businessId);
        else
            throw new InvalidTokenException("Invalid token");
    }
}