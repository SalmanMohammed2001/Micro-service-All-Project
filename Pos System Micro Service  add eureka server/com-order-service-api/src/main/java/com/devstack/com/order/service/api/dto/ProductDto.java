package com.devstack.com.order.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
