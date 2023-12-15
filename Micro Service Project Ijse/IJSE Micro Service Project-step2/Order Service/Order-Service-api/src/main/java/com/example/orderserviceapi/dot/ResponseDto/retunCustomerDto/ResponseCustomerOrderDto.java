package com.example.orderserviceapi.dot.ResponseDto.retunCustomerDto;

import com.example.orderserviceapi.dot.ResponseDto.ResponseOrderDto;
import com.example.orderserviceapi.dot.core.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCustomerOrderDto {
    private List<OrderDto> orderDtos;
}
