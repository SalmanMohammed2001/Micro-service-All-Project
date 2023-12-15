package com.devstack.com.order.service.api.service;


import com.devstack.com.order.service.api.dto.OrdersDto;
import com.devstack.com.order.service.api.dto.ResponseOrderAndPlacerOrderDto;
import com.devstack.com.order.service.api.dto.ResponseOrderDto;

import java.util.List;

public interface OrderService {

    public void  saveOrder(OrdersDto dto);

    public ResponseOrderDto getAllOrderByCustomer(long id);

    public ResponseOrderAndPlacerOrderDto findByOrderAndOrderDetails(long id);



}
