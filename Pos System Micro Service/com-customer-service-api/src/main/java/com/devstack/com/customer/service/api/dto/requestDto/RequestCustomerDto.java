package com.devstack.com.customer.service.api.dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCustomerDto {

    private long id;
    private String name;
    private String address;
    private double salary;



}
