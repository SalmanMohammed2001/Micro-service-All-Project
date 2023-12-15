package com.devstack.placeorderserviceapo.service;

import com.devstack.placeorderserviceapo.dto.PlaceOrderDto;
import com.devstack.placeorderserviceapo.dto.ResponsePlaceOrder;

public interface PlaceOrderService {
    public void save(PlaceOrderDto dto);

    public ResponsePlaceOrder responsePlaceOrder(long id);
}
