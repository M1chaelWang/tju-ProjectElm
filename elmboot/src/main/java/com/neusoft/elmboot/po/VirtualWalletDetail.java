package com.neusoft.elmboot.po;

import java.math.BigDecimal;

public class VirtualWalletDetail {
    private Integer detailId;
    private String time;
    private BigDecimal amount;
    private Integer type; // 1-recharge 2-withdraw 3-transfer
    private Integer inWalletId; // for 1 & 3
    private Integer outWalletId; // for 2 & 3

    public Integer getDetailId() {
        return detailId;
    }
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getInWalletId() {
        return inWalletId;
    }
    public void setInWalletId(Integer inWalletId) {
        this.inWalletId = inWalletId;
    }
    public Integer getOutWalletId() {
        return outWalletId;
    }
    public void setOutWalletId(Integer outWalletId) {
        this.outWalletId = outWalletId;
    }
}
