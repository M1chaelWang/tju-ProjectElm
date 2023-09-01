package com.neusoft.elm.dao;

import java.util.List;

import com.neusoft.elm.po.DeliveryAddress;

public interface DeliveryAddressDao {
	
	//根据UserId查询送货地址
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) throws Exception;
	//添加送货地址
	public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception;
	//根据ID查询送货地址
	public DeliveryAddress getDeliveryAddressById(Integer daId) throws Exception;
	//更新送货地址
	public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception;
	//移除送货地址
	public int removeDeliveryAddress(Integer daId) throws Exception;
}