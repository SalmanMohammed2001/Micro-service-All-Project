package com.example.customerserviceapi.dot.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RequestCustomerDto {
    private String customerId;
    private String name;
    private String address;
    private double salary;
}
