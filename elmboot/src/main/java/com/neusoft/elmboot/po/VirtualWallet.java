package com.neusoft.elmboot.po;

import java.math.BigDecimal;

public class VirtualWallet {
    private Integer walletId;
    private String userId;
    private BigDecimal balance;

    public Integer getWalletId() {
        return walletId;
    }
    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void add(BigDecimal amount) {
        balance = amount.add(balance);
    }
    public void substract(BigDecimal amount) {
        balance = amount.subtract(balance);
    }
}
