package com.devstack.com.order.service.api.api;


import com.devstack.com.order.service.api.dto.OrdersDto;
import com.devstack.com.order.service.api.dto.ResponseOrderAndPlacerOrderDto;
import com.devstack.com.order.service.api.dto.ResponseOrderDto;
import com.devstack.com.order.service.api.service.OrderService;
import com.devstack.com.order.service.api.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void save(@RequestBody OrdersDto ordersDto ) {
        orderService.saveOrder(ordersDto);

    }
    /*public void save(@RequestBody OrdersDto dto) {
        orderService.saveOrder(dto);

    }*/
 /*   public ResponseEntity<StandardResponse> save(@RequestBody OrdersDto dto) {
        orderService.saveOrder(dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "saved", null), HttpStatus.CREATED
        );
    }*/

    @GetMapping(path = "get-by-customer-id/{id}")
    public ResponseOrderDto findByCustomerDetails(@PathVariable Long id) {
        ResponseOrderDto allOrderByCustomer = orderService.getAllOrderByCustomer(id);
        return allOrderByCustomer;

    }

    @GetMapping(path = "get-by-order-details/{id}")
    public ResponseEntity<StandardResponse>findOrderDetails(@PathVariable long id){
        ResponseOrderAndPlacerOrderDto byOrderAndOrderDetails = orderService.findByOrderAndOrderDetails(id);
        return new ResponseEntity<>(new StandardResponse(200,"All Details",byOrderAndOrderDetails), HttpStatus.OK);
    }



}
