package com.example.customerserviceapi.dot.ResponseDto;


import com.example.customerserviceapi.dot.core.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCustomerOrderDto {
    private List<ResponseOrderDto> orderDtos;
}
