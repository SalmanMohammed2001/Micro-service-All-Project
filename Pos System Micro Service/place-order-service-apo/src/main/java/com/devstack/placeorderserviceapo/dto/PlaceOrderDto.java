package com.devstack.placeorderserviceapo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceOrderDto {
    private long id;

    private long orderId;

    private  long productId;

    private int qty;

    private double total;
}
