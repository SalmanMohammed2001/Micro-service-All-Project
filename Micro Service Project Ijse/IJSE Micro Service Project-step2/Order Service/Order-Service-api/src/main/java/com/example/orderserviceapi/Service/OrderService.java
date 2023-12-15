package com.example.orderserviceapi.Service;




import com.example.orderserviceapi.dot.RequestDto.RequestOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.ResponseOrderAndPlaceOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.retunCustomerDto.ResponseCustomerOrderDto;

public interface OrderService {

    public void   Order(RequestOrderDto dto);

    public ResponseOrderAndPlaceOrderDto orderAndPlaceOrder(String id);

    public ResponseCustomerOrderDto getAllOrderByCustomer(String id);

}
