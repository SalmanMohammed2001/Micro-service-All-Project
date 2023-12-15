package com.example.customerserviceapi.dot.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrderDto {
    private String orderId;
    private String customerId;
    private String date;
    private double total;
}
