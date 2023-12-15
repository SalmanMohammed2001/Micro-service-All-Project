package com.example.orderserviceapi.dot.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsePlaceOrderDto {
    private String id;
    private String orderId;
    private  String productId;
    private int qty;
    private double total;
}
