package com.example.orderserviceapi.dot.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ResponseOrderDto {
    private String orderId;
    private String customerId;
    private String date;
    private double total;
}
