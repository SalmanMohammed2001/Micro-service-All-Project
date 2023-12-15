package com.example.itemserviceapi.api;


import com.example.itemserviceapi.Service.ItemService;
import com.example.itemserviceapi.dot.RequestDto.RequestItemDto;
import com.example.itemserviceapi.dot.ResponseDto.ResponseItemDto;
import com.example.itemserviceapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    public ResponseEntity<StandardResponse> save(@RequestBody RequestItemDto dto){
        ResponseItemDto responseCustomerDto = itemService.saveItem(dto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer Saved",responseCustomerDto), HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> update(@RequestBody RequestItemDto dto){
        ResponseItemDto responseCustomerDto = itemService.updateItem(dto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer update",responseCustomerDto), HttpStatus.OK
        );
    }

    @DeleteMapping(params = {"itemCode"})
    public ResponseEntity<StandardResponse> delete(@RequestParam String itemCode){
        itemService.deleteItem(itemCode);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer delete",null), HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StandardResponse> find(@PathVariable String id){
        System.out.println(id);
        ResponseItemDto responseItemDto = itemService.findItem(id);
        return new ResponseEntity<>(
                new StandardResponse(200," find Customer ",responseItemDto), HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<StandardResponse> findAll(){
        List<ResponseItemDto> all = itemService.findAllItem();
        return new ResponseEntity<>(
                new StandardResponse(200,"All customer ",all), HttpStatus.OK
        );
    }

    @GetMapping(path = "item-code/{id}")
    public ResponseItemDto findByItem(@PathVariable String id){
        ResponseItemDto item = itemService.findItem(id);
        return item;
    }
}
