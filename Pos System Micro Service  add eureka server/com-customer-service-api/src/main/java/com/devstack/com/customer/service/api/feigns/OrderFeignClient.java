package com.devstack.com.customer.service.api.feigns;


import com.devstack.com.customer.service.api.dto.core.OrdersDto;
import com.devstack.com.customer.service.api.dto.responseDto.ResponseOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(path = "api/v1/orders",value = "order-service-api")
public interface OrderFeignClient {
    @GetMapping(path = "get-by-customer-id/{id}")
    public ResponseOrderDto findOrderByCustomer(@PathVariable long id);

    @PostMapping
    public void save(@RequestBody OrdersDto ordersDto);
}


