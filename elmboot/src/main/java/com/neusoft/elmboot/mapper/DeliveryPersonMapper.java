package com.neusoft.elmboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.elmboot.po.DeliveryPerson;

@Mapper
public interface DeliveryPersonMapper {
    @Select("select * from deliveryperson where personId=#{personId}")
    public DeliveryPerson getDeliveryPersonById(Integer personId);
}
