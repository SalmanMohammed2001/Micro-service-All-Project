package com.example.orderserviceapi.feigns;


import com.example.orderserviceapi.dot.RequestDto.RequestItemDto;
import com.example.orderserviceapi.dot.RequestDto.RequestPlaceOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.ResponseItemDto;
import com.example.orderserviceapi.util.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(path = "api/v1/item", value = "item-service-api")
public interface ProductFeignClient {

    @GetMapping(path = "item-code/{id}")
    public ResponseItemDto findByItem(@PathVariable String id);


    @PutMapping
    public ResponseEntity<StandardResponse> update(@RequestBody RequestItemDto dto);
}
