package com.example.customerserviceapi.dot.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ResponseCustomerDto {
    private String customerId;
    private String name;
    private String address;
    private double salary;
}
