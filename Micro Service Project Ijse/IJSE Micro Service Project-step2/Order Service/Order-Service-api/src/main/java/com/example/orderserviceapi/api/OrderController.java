package com.example.orderserviceapi.api;


import com.example.orderserviceapi.Service.OrderService;
import com.example.orderserviceapi.dot.RequestDto.RequestOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.ResponseOrderAndPlaceOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.retunCustomerDto.ResponseCustomerOrderDto;
import com.example.orderserviceapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<StandardResponse> save(@RequestBody RequestOrderDto dto){
         orderService.Order(dto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer Saved",null), HttpStatus.OK
        );
    }

    @GetMapping(path = "order-id/{id}")
    public ResponseEntity<StandardResponse> findAllOrderAndPlaceOrder(@PathVariable String id){
        ResponseOrderAndPlaceOrderDto responseOrderAndPlaceOrderDto = orderService.orderAndPlaceOrder(id);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer Saved",responseOrderAndPlaceOrderDto), HttpStatus.OK
        );
    }

    @GetMapping("customer-id/{id}")
    public ResponseCustomerOrderDto responseCustomerOrderDto(@PathVariable String id){
        System.out.println(id);
       ResponseCustomerOrderDto allOrderByCustomer = orderService.getAllOrderByCustomer(id);
        return allOrderByCustomer;

    }


}
