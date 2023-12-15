package com.devstack.com.customer.service.api.dto.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrdersDto {
    private long orderId;
    private long customerId;
    private long productId;
    private double cost;
}
