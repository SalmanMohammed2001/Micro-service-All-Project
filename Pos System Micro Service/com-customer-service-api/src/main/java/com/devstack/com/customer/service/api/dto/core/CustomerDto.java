package com.devstack.com.customer.service.api.dto.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerDto {

    private long id;
    private String name;
    private String address;
    private double salary;
}
