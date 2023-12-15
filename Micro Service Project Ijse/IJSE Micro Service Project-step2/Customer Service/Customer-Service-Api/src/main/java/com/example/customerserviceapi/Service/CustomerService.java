package com.example.customerserviceapi.Service;


import com.example.customerserviceapi.dot.RequestDto.ResponseCustomerDto;
import com.example.customerserviceapi.dot.ResponseDto.RequestCustomerDto;
import com.example.customerserviceapi.dot.ResponseDto.ResponseCustomerAndOrderDto;

import java.util.List;

public interface CustomerService {

    public ResponseCustomerDto  saveCustomer(RequestCustomerDto dto);
    public ResponseCustomerDto  updateCustomer(RequestCustomerDto dto);
    public void  deleteCustomer(String id);
    public ResponseCustomerDto  findCustomer(String id);
    public List<ResponseCustomerDto>  findAllCustomer();

    public ResponseCustomerAndOrderDto responseCustomerAndOrderDto(String id);
}
