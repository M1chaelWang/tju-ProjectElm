package com.neusoft.elmboot;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {

    @Value("${my.publicKey}")
    private String publicKey;

    @Value("${my.privateKey}")
    private String privateKey;

    @Value("${my.AESKey}")
    private String AESKey;

    private String password;

    private static SecurityConfig instance = new SecurityConfig();

    private SecurityConfig() {
    }

    public static SecurityConfig getInstance() {
        return instance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getAESKey() {
        return AESKey;
    }

    public Boolean isValidToken(String token) {
        byte[] encryptedText = hexToBytes(token);
        byte[] decodedKey = Base64.getDecoder().decode(AESKey);
        SecretKey originalAESKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        try {
            String decryptedText = decryptWithAESKey(encryptedText, originalAESKey);
            //if (decryptedText.equals("123"))
            if (decryptedText.equals(this.password))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public byte[] decryptWithPrivateKey(byte[] data, String privateKey) throws Exception {
        PrivateKey privateKeyObj = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKeyObj);
        return cipher.doFinal(data);
    }

    public static byte[] encryptWithAESKey(String text, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(text.getBytes());
    }

    public static String decryptWithAESKey(byte[] cipherText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }

    public static byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

}
