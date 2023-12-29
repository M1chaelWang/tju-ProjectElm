package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.Points;
import com.neusoft.elmboot.service.PointsService;

@RestController
@RequestMapping("/points")
public class PointsController {
    @Autowired
    private PointsService pointsService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/user/{userId}") 
    public List<Points> listPointsByOrderUserId(@PathVariable("userId") String userId, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return pointsService.listPointsByOrderUserId(userId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PostMapping("/add")
    public int savePoints(@RequestBody Points points, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return pointsService.savePoints(points);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @GetMapping("/{userId}/usePoints")
    public Boolean usePoint(@PathVariable("userId") String userId, @RequestParam Integer points, @RequestHeader("token") String token) throws Exception {
        if (securityConfig.isValidToken(token))
            return pointsService.usePoints(userId, points);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @GetMapping("/validPoints")
    public int getValidPoints(@RequestParam("userId") String userId, @RequestHeader("token") String token) {
        if (securityConfig.isValidToken(token))
            return pointsService.sumValidPoint(userId);
        else
            throw new InvalidTokenException("Invalid token");
    }
}
