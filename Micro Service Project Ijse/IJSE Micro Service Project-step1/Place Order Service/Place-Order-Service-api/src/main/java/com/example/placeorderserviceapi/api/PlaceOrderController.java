package com.example.placeorderserviceapi.api;


import com.example.placeorderserviceapi.dto.RequestDto.RequestPlaceOrderDto;
import com.example.placeorderserviceapi.dto.ResponseDto.ResponseOrderPlaceDto;
import com.example.placeorderserviceapi.dto.ResponseDto.ResponsePlaceOrderDto;
import com.example.placeorderserviceapi.service.PlaceOrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/place-order")
public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    public PlaceOrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    @PostMapping
    public void  save(@RequestBody RequestPlaceOrderDto placeOrderDto){
    System.out.println(placeOrderDto.getOrderId());
    System.out.println(placeOrderDto.getId());
    placeOrderService.save(placeOrderDto);
    }


    @GetMapping(path = "place-order/{id}")
    public ResponsePlaceOrderDto responsePlaceOrderDto(@PathVariable String id){
        ResponsePlaceOrderDto placeOrder = placeOrderService.findPlaceOrder(id);
        return placeOrder;

    }

    @GetMapping(path = "order-id/{id}")
    public ResponseOrderPlaceDto responseOrderDto(@PathVariable String id){
        return placeOrderService.findBYOrderId(id);
    }
}
