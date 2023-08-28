package com.neusoft.elm.service;

import java.util.List;

import com.neusoft.elm.po.DeliveryAddress;

public interface DeliveryAddressService {

	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
	//添加送货地址
	public int saveDeliveryAddress(DeliveryAddress deliveryAddress);
	//根据ID查询送货地址
	public DeliveryAddress getDeliveryAddressById(Integer daId);
	//更新送货地址
	public int updateDeliveryAddress(DeliveryAddress deliveryAddress);
	//删除送货地址
	public int removeDeliveryAddress(Integer daId);
}
