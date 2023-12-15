package com.devstack.com.customer.service.api.service;


import com.devstack.com.customer.service.api.dto.core.CustomerDto;
import com.devstack.com.customer.service.api.dto.responseDto.ResponseCustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CustomerService {

    public void saveCustomer(CustomerDto dto) throws JsonProcessingException;

    public ResponseCustomerDto findCustomerById(long id);


}
