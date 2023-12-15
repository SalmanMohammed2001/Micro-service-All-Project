package com.example.placeorderserviceapi.service;


import com.example.placeorderserviceapi.dto.RequestDto.RequestPlaceOrderDto;
import com.example.placeorderserviceapi.dto.ResponseDto.ResponseOrderPlaceDto;
import com.example.placeorderserviceapi.dto.ResponseDto.ResponsePlaceOrderDto;

public interface PlaceOrderService {
    public void save(RequestPlaceOrderDto dto);

    public ResponsePlaceOrderDto findPlaceOrder(String id);

    public ResponseOrderPlaceDto findBYOrderId(String id);





}
