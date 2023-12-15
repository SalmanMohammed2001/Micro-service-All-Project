package com.devstack.com.order.service.api.feigns;


import com.devstack.com.order.service.api.dto.PlaceOrderDto;
import com.devstack.com.order.service.api.dto.ResponsePlacerOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(path = "api/v1/place-order",value = "placer-order-service-api")
public interface PlacerOrderFeignClient {


    @PostMapping
    public void save(@RequestBody PlaceOrderDto placeOrderDto);

    @GetMapping(path = "{id}")
    public ResponsePlacerOrderDto get(@PathVariable long id);

}


