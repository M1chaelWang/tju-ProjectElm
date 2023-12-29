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
import com.neusoft.elmboot.po.Food;
import com.neusoft.elmboot.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/business/{businessId}")
    public List<Food> listFoodByBusinessId(@PathVariable("businessId") Integer businessId,
            @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return foodService.listFoodByBusinessId(businessId);
        else
            throw new InvalidTokenException("Invalid token");
    }
}
