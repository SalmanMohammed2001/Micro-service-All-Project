package com.example.orderserviceapi.dot.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderAndPlaceOrderDto {
  private ResponseOrderDto orderDtol;
  private   ResponseOrderPlaceDto responseOrderPlaceDto;
}
