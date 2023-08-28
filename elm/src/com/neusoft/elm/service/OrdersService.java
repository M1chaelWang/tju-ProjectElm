package com.neusoft.elm.service;

<<<<<<< HEAD
import com.neusoft.elm.po.Orders;

public interface OrdersService {
	
	public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);
	public Orders getOrdersById(Integer orderId);
=======
import java.util.List;

import com.neusoft.elm.po.Orders;

public interface OrdersService {

	public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);

	public Orders getOrdersById(Integer orderId);

	// 查询历史订单
	public List<Orders> listOrdersByUserId(String userId);
>>>>>>> 1af82b4f7ad252677d10555067ef2457aeadf70e
}
