package com.neusoft.elmboot.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.VirtualWalletDetailMapper;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.po.VirtualWallet;
import com.neusoft.elmboot.po.VirtualWalletDetail;
import com.neusoft.elmboot.service.VirtualWalletService;
import com.neusoft.elmboot.util.CommonUtil;

@Service
public class VirtualWalletServiceImpl implements VirtualWalletService {
    @Autowired
    private VirtualWalletMapper virtualWalletMapper;
    @Autowired
    private VirtualWalletDetailMapper virtualWalletDetailMapper;

    @Override
    public VirtualWallet getVirtualWalletByUserId(String userId) {
        if (virtualWalletMapper.getVirtualWalletByUserId(userId) != null)
            return virtualWalletMapper.getVirtualWalletByUserId(userId);
        else {
            VirtualWallet wallet = new VirtualWallet();
            wallet.setUserId(userId);
            wallet.setBalance(BigDecimal.valueOf(0.00));
            virtualWalletMapper.save(wallet);
            return virtualWalletMapper.getVirtualWalletByUserId(userId);
        }
    }

    @Override
    public VirtualWallet getVirtualWalletByWalletId(Integer walletId) {
        return virtualWalletMapper.getVirtualWalletByWalletId(walletId);
    }

    @Override
    public void recharge(Integer inWalletId, BigDecimal amount) {
        VirtualWallet wallet = getVirtualWalletByWalletId(inWalletId);
        if (wallet == null) {
            return;
        }
        wallet.add(amount);
        virtualWalletMapper.add(inWalletId, amount);

        VirtualWalletDetail transaction = new VirtualWalletDetail();
        transaction.setTime(CommonUtil.getCurrentDate());
        transaction.setAmount(amount);
        transaction.setType(1);
        transaction.setInWalletId(inWalletId);
        virtualWalletDetailMapper.save(transaction);
    }

    @Override
    public boolean withdraw(Integer outWalletId, BigDecimal amount) {
        VirtualWallet wallet = getVirtualWalletByWalletId(outWalletId);
        if (wallet == null) {
            return false;
        }
        if (wallet.getBalance().compareTo(amount) == -1) // balance < amount
            return false;
        wallet.substract(amount);
        virtualWalletMapper.substract(outWalletId, amount);

        VirtualWalletDetail transaction = new VirtualWalletDetail();
        transaction.setTime(CommonUtil.getCurrentDate());
        transaction.setAmount(amount);
        transaction.setType(2);
        transaction.setOutWalletId(outWalletId);
        virtualWalletDetailMapper.save(transaction);
        return true;
    }

    @Override
    public boolean transfer(Integer inWalletId, Integer outWalletId, BigDecimal amount) {
        VirtualWallet outWallet = getVirtualWalletByWalletId(outWalletId);
        if (outWallet == null) {
            return false;
        }
        if (outWallet.getBalance().compareTo(amount) == -1) // balance < amount
            return false;
        outWallet.substract(amount);
        virtualWalletMapper.substract(outWalletId, amount);

        VirtualWallet inWallet = getVirtualWalletByWalletId(inWalletId);
        if (inWallet == null) {
            return false;
        }
        inWallet.add(amount);
        virtualWalletMapper.add(inWalletId, amount);

        VirtualWalletDetail transaction = new VirtualWalletDetail();
        transaction.setTime(CommonUtil.getCurrentDate());
        transaction.setAmount(amount);
        transaction.setType(3);
        transaction.setInWalletId(inWalletId);
        transaction.setOutWalletId(outWalletId);
        virtualWalletDetailMapper.save(transaction);
        return true;
    }

}
