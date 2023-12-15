package com.example.customerserviceapi.feigns;


import com.example.customerserviceapi.dot.ResponseDto.ResponseCustomerOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "api/v1/order" ,value = "order-service-api")
public interface OrderFeignsClient {


    @GetMapping("customer-id/{id}")
    public ResponseCustomerOrderDto responseCustomerOrderDto(@PathVariable String id);
}
