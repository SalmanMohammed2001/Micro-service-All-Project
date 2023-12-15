package com.devstack.com.customer.service.api.dto.responseDto;

import com.devstack.com.customer.service.api.dto.core.OrdersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDto {
    private List<OrdersDto> list;
}
