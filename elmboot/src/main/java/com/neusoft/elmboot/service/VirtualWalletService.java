package com.neusoft.elmboot.service;

import java.math.BigDecimal;

import com.neusoft.elmboot.po.VirtualWallet;

public interface VirtualWalletService {

    public VirtualWallet getVirtualWalletByUserId(String userId);

    public VirtualWallet getVirtualWalletByWalletId(Integer walletId);

    public void recharge(Integer inWalletId, BigDecimal amount);

    public boolean withdraw(Integer outWalletId, BigDecimal amount);

    public boolean transfer(Integer inWalletId, Integer outWalletId, BigDecimal amount);

}
