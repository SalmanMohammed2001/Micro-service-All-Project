package com.example.placeorderserviceapi.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestPlaceOrderDto {
    private String id;
    private String orderId;
    private  String productId;
    private int qty;
    private double total;
}
