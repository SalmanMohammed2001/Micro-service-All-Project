package com.example.customerserviceapi.dot.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerDto {
    private String customerId;
    private String name;
    private String address;
    private double salary;
}
