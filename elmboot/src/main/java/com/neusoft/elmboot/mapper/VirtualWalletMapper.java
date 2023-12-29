package com.neusoft.elmboot.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.elmboot.po.VirtualWallet;

@Mapper
public interface VirtualWalletMapper {
    @Select("select * from virtualwallet where userId=#{userId}")
    VirtualWallet getVirtualWalletByUserId(String userId);

    @Select("select * from virtualwallet where walletId=#{walletId}")
    VirtualWallet getVirtualWalletByWalletId(Integer walletId);

    @Insert("insert into virtualwallet values(#{walletId},#{userId},#{balance})")
    void save(VirtualWallet wallet);

    @Update("update virtualwallet set balance=balance+ #{amount} where walletId=#{inWalletId}")
    void add(Integer inWalletId, BigDecimal amount);

    @Update("update virtualwallet set balance=balance- #{amount} where walletId=#{outWalletId}")
    void substract(Integer outWalletId, BigDecimal amount);

}
