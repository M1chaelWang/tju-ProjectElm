package com.neusoft.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.InvalidTokenException;
import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.Cart;
import com.neusoft.elmboot.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

	@PostMapping("/list")
    public List<Cart> listCart(@RequestBody Cart cart, @RequestHeader("token") String token) throws Exception {
		if (securityConfig.isValidToken(token))
        	return cartService.listCart(cart);
		else
            throw new InvalidTokenException("Invalid token");
    }

	@PostMapping("/remove")
	public int removeCart(@RequestBody Cart cart, @RequestHeader("token") String token) throws Exception {
		if (securityConfig.isValidToken(token))
			return cartService.removeCart(cart);
		else
            throw new InvalidTokenException("Invalid token");
	}
	
	@PostMapping("/add")
	public int saveCart(@RequestBody Cart cart, @RequestHeader("token") String token) throws Exception {
		if (securityConfig.isValidToken(token))
			return cartService.saveCart(cart);
		else
            throw new InvalidTokenException("Invalid token");
	}

	@PutMapping("/update")
	public int updateCart(@RequestBody Cart cart, @RequestHeader("token") String token) throws Exception {
		if (securityConfig.isValidToken(token))
			return cartService.updateCart(cart);
		else
            throw new InvalidTokenException("Invalid token");
	}


}
