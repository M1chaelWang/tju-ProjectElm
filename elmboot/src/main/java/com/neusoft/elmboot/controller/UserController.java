package com.neusoft.elmboot.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.SecurityConfig;
import com.neusoft.elmboot.po.User;
import com.neusoft.elmboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityConfig securityConfig = SecurityConfig.getInstance();

    @GetMapping("/user")
    public List<Object> getUserByIdByPass(User user) throws Exception {
        String privateKeyString = securityConfig.getPrivateKey();
        try {
            byte[] decryptedBytes = securityConfig
                    .decryptWithPrivateKey(Base64.getDecoder().decode(user.getPassword().getBytes()), privateKeyString);
            String decryptedData = new String(decryptedBytes, StandardCharsets.UTF_8);
			user.setPassword(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        securityConfig.setPassword(user.getPassword());

        String AESKey = securityConfig.getAESKey();
        byte[] decodedKey = Base64.getDecoder().decode(AESKey);
        SecretKey originalAESKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        byte[] encryptedText = SecurityConfig.encryptWithAESKey(user.getPassword(), originalAESKey);
        String token = SecurityConfig.bytesToHex(encryptedText);

        List<Object> response = new ArrayList<>();
        response.add(userService.getUserByIdByPass(user));
        response.add(token);
        return response;
    }

    @GetMapping("/{userId}")
    public int getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/add")
    public int saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
