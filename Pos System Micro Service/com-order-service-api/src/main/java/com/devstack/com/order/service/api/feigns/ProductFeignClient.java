package com.devstack.com.order.service.api.feigns;


import com.devstack.com.order.service.api.dto.ProductDto;
import com.devstack.com.order.service.api.util.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${product-url}",path = "api/v1/products",value = "product-feign-client")
public interface ProductFeignClient {


    @GetMapping(path = "get-product-id/{id}")
    public ProductDto findByProduct(@PathVariable long id);


    @PostMapping
    public ResponseEntity<StandardResponse> createProduct(@RequestBody ProductDto productDto);

}


