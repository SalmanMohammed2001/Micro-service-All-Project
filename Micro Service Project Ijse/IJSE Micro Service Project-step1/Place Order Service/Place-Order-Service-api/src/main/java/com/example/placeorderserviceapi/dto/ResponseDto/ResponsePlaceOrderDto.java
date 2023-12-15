package com.example.placeorderserviceapi.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePlaceOrderDto {
    private String id;
    private String orderId;
    private  String productId;
    private int qty;
    private double total;
}
