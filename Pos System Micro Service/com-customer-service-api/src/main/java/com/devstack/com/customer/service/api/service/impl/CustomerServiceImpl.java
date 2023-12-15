package com.devstack.com.customer.service.api.service.impl;

import com.devstack.com.customer.service.api.dto.core.CustomerDto;
import com.devstack.com.customer.service.api.dto.core.OrdersDto;
import com.devstack.com.customer.service.api.dto.responseDto.ResponseCustomerDto;
import com.devstack.com.customer.service.api.dto.responseDto.ResponseOrderDto;
import com.devstack.com.customer.service.api.entity.Customer;
import com.devstack.com.customer.service.api.feigns.OrderFeignClient;
import com.devstack.com.customer.service.api.repo.CustomerRepo;
import com.devstack.com.customer.service.api.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final OrderFeignClient orderFeignClient;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, OrderFeignClient orderFeignClient) {
        this.customerRepo = customerRepo;
        this.orderFeignClient = orderFeignClient;
    }


    @Override
    public void saveCustomer(CustomerDto dto) throws JsonProcessingException {
        customerRepo.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
        OrdersDto ordersDto = new OrdersDto(9, 3, 40, 500);
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();

        String json = gson.toJson(ordersDto);
        OrdersDto ordersDto1 = gson.fromJson(json, OrdersDto.class);
      //  orderFeignClient.save(ordersDto1);
        //System.out.println(ordersDto1.getCustomerId());
    }

    @Override
    public ResponseCustomerDto findCustomerById(long id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw new RuntimeException("Not found");
        }

        ResponseOrderDto orders = orderFeignClient.findOrderByCustomer(selectedCustomer.get().getId());
        CustomerDto customerDto = new CustomerDto(selectedCustomer.get().getId(),
                selectedCustomer.get().getName(), selectedCustomer.get().getAddress(),
                selectedCustomer.get().getSalary());

        return new ResponseCustomerDto(customerDto,orders);
    }



}
