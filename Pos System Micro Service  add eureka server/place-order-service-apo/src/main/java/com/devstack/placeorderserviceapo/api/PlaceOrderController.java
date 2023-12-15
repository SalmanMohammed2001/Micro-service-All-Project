package com.devstack.placeorderserviceapo.api;

import com.devstack.placeorderserviceapo.dto.PlaceOrderDto;
import com.devstack.placeorderserviceapo.dto.ResponsePlaceOrder;
import com.devstack.placeorderserviceapo.service.PlaceOrderService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/place-order")
public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    @GetMapping(path = "{id}")
    public ResponsePlaceOrder get(@PathVariable long id){
        return placeOrderService.responsePlaceOrder(id);

    }
    @PostMapping
    public void  save(@RequestBody PlaceOrderDto placeOrderDto){
    System.out.println(placeOrderDto.getOrderId());
    System.out.println(placeOrderDto.getId());
    placeOrderService.save(placeOrderDto);
    }
}
