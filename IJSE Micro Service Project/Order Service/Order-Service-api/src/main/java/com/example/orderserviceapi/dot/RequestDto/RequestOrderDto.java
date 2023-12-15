package com.example.orderserviceapi.dot.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RequestOrderDto {
    private String orderId;
    private String customerId;
    private String date;
    private double total;
    private List<RequestPlaceOrderDto> placeOrderDtos;
}
