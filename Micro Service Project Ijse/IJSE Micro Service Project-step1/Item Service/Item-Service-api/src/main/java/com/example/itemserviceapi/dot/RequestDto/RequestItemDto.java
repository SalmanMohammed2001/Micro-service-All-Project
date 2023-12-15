package com.example.itemserviceapi.dot.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RequestItemDto {
    private String itemCode;
    private String description;
    private double unitePrice;
    private int qtyOnHand;
}
