package com.example.customerserviceapi.dot.ResponseDto;

import com.example.customerserviceapi.dot.RequestDto.ResponseCustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCustomerAndOrderDto{
    private ResponseCustomerDto responseCustomerDto;
    private ResponseCustomerOrderDto responseCustomerOrderDto;
}
