package com.example.itemserviceapi.dot.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ItemDto {
    private String itemCode;
    private String description;
    private double unitePrice;
    private int qtyOnHand;
}
