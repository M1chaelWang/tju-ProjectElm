package com.neusoft.elmboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.elmboot.po.DeliveryPerson;
import com.neusoft.elmboot.service.DeliveryPersonService;

@RestController
@RequestMapping("/DeliveryPersonController")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @RequestMapping("/getDeliveryPersonById")
    public DeliveryPerson getDeliveryPersonById(Integer personId) throws Exception {
        return deliveryPersonService.getDeliveryPersonById(personId);
    }

}
