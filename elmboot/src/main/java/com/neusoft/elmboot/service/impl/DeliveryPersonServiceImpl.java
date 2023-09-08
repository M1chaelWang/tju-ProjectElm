package com.neusoft.elmboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.elmboot.mapper.DeliveryPersonMapper;
import com.neusoft.elmboot.po.DeliveryPerson;
import com.neusoft.elmboot.service.DeliveryPersonService;

@Service
public class DeliveryPersonServiceImpl implements DeliveryPersonService{
    
    @Autowired
	private DeliveryPersonMapper deliveryPersonMapper;

    @Override
    public DeliveryPerson getDeliveryPersonById(Integer personId) {
        return deliveryPersonMapper.getDeliveryPersonById(personId);
    }
}
