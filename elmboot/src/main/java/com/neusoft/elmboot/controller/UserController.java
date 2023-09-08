package com.neusoft.elmboot.controller;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.po.User;
import com.neusoft.elmboot.service.UserService;

@RestController
@RequestMapping("/UserController")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/getUserByIdByPass")
	public User getUserByIdByPass(User user) throws Exception {
		String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEApShMUM9wkzBleQ0u62u+iRlbnFDP/K2lAlVBMQunLjXXc/97kKyDw5RDpA+h6hAhPDkaOfa0YLglQYjEhEfMMwIDAQABAkBHTDJF4Id0wzvLGknbD9RdUzkdLjXbmwrVCwDtr14osBwWtS0oZpAOAbbwaCTPnxTlgyGWhPLBbVdjsQqFt6ZBAiEA0VZo1tbtTR1eckukQ2J+dZ0mMnr0Nwt5lH8u4V0ZBGkCIQDJ+M3N5mmu2CRT13f0KFf49mjfxL3asSPYz+I/BkyIOwIgAznjr7vsOE4FkJld1LQF4uYjGpAOh3Kj0wgKvupiYlECIQCNGBH18CwOKBKgu5qh53klhEZZZGDZIPyQ3xEHxEe8twIgDipYZ0M9JITNIPOFDW3jaKAnL6pSUdwR1tANKSyWoU8=";
		try {
            byte[] decryptedBytes = decryptWithPrivateKey(Base64.getDecoder().decode(user.getPassword()), privateKey);
            String decryptedData = new String(decryptedBytes, StandardCharsets.UTF_8);
			user.setPassword(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return userService.getUserByIdByPass(user);
	}

	@RequestMapping("/getUserById")
	public int getUserById(User user) throws Exception {
		return userService.getUserById(user.getUserId());
	}

	@RequestMapping("/saveUser")
	public int saveUser(User user) throws Exception {
		return userService.saveUser(user);
	}

	@RequestMapping("/updateTotalPoints")
	public void updateTotalPoints(String userId, Integer totalPoints) throws Exception {
		userService.updateTotalPoints(userId, totalPoints);
	}

	@RequestMapping("/getTotalPoints")
	public int getTotalPoints(String userId) throws Exception {
		return userService.getTotalPoints(userId);
	}

	@RequestMapping("/subTotalPoints")
	public void subTotalPoints(String userId, Integer totalPoints) throws Exception {
		userService.subTotalPoints(userId, totalPoints);
	}

	// 解密方法
    private byte[] decryptWithPrivateKey(byte[] data, String privateKey) throws Exception {
        PrivateKey privateKeyObj = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKeyObj);
        return cipher.doFinal(data);
    }
}
