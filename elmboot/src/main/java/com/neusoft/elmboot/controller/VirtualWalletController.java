package com.neusoft.elmboot.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.service.VirtualWalletService;

@RestController
@RequestMapping("/virtualWallets")
public class VirtualWalletController {

    @Autowired
    private VirtualWalletService virtualWalletService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/user/{userId}")
    public VirtualWallet getVirtualWalletByUserId(@PathVariable("userId") String userId,
            @RequestHeader("token") String token) {
        if (securityConfig.isValidToken(token))
            return virtualWalletService.getVirtualWalletByUserId(userId);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PostMapping("/recharge")
    public void recharge(@RequestParam("inWalletId") Integer inWalletId, @RequestParam("amount") BigDecimal amount,
            @RequestHeader("token") String token) {
        if (securityConfig.isValidToken(token))
            virtualWalletService.recharge(inWalletId, amount);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PostMapping("/withdraw")
    public boolean withdraw(@RequestParam("outWalletId") Integer outWalletId,
            @RequestParam("amount") BigDecimal amount, @RequestHeader("token") String token) {
        if (securityConfig.isValidToken(token))
            return virtualWalletService.withdraw(outWalletId, amount);
        else
            throw new InvalidTokenException("Invalid token");
    }

    @PostMapping("/transfer")
    public boolean transfer(@RequestParam("inWalletId") Integer inWalletId,
            @RequestParam("outWalletId") Integer outWalletId, @RequestParam("amount") BigDecimal amount,
            @RequestHeader("token") String token) {
        if (securityConfig.isValidToken(token))
            return virtualWalletService.transfer(inWalletId, outWalletId, amount);
        else
            throw new InvalidTokenException("Invalid token");
    }
}
