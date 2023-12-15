package com.devstack.com.order.service.api.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDto {
    private long orderId;
    private long customerId;
    private long productId;
    private double cost;
    private List<PlaceOrderDto> placeOrderDtos;
}
