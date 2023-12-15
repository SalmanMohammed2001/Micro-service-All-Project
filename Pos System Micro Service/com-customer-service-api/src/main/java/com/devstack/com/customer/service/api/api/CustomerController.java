package com.devstack.com.customer.service.api.api;


import com.devstack.com.customer.service.api.dto.core.CustomerDto;
import com.devstack.com.customer.service.api.dto.responseDto.ResponseCustomerDto;
import com.devstack.com.customer.service.api.service.CustomerService;

import com.devstack.com.customer.service.api.util.StandardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody CustomerDto dto) throws JsonProcessingException {
        customerService.saveCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"saved",null), HttpStatus.CREATED
        );
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<StandardResponse> findById(@PathVariable long id){
        ResponseCustomerDto all = customerService.findCustomerById(id);
        return new ResponseEntity<>(
                new StandardResponse(201,"saved",all), HttpStatus.CREATED
        );
    }








}
