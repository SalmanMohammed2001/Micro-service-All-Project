package com.example.orderserviceapi.feigns;

import com.example.orderserviceapi.dot.RequestDto.RequestPlaceOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.ResponseOrderPlaceDto;
import com.example.orderserviceapi.dot.ResponseDto.ResponsePlaceOrderDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(path = "api/v1/place-order", value = "place-order-service-api")
public interface PlacerOrderFeignClient {
    @PostMapping
    public void save(@RequestBody RequestPlaceOrderDto placeOrderDto);

    @GetMapping(path = "order-id/{id}")
    public ResponseOrderPlaceDto responseOrderDto(@PathVariable String id);

}