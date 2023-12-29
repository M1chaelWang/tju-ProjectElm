package com.neusoft.elmboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.neusoft.elmboot.po.VirtualWalletDetail;

@Mapper
public interface VirtualWalletDetailMapper {

    @Insert("insert into virtualwalletdetail values(#{detailId},#{time},#{amount},#{type},#{inWalletId},#{outWalletId})")
    void save(VirtualWalletDetail transaction);
}