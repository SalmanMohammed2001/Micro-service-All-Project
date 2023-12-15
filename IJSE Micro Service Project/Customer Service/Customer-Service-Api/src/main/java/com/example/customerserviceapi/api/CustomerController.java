package com.example.customerserviceapi.api;

import com.example.customerserviceapi.Service.CustomerService;
import com.example.customerserviceapi.dot.RequestDto.ResponseCustomerDto;
import com.example.customerserviceapi.dot.ResponseDto.RequestCustomerDto;
import com.example.customerserviceapi.dot.ResponseDto.ResponseCustomerAndOrderDto;
import com.example.customerserviceapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> save(@RequestBody RequestCustomerDto dto){
        System.out.println(dto.getCustomerId());
        System.out.println(dto.getName());
        ResponseCustomerDto responseCustomerDto = customerService.saveCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer Saved",responseCustomerDto), HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> update(@RequestBody RequestCustomerDto dto){
        System.out.println(dto.getCustomerId());
        System.out.println(dto.getName());
        ResponseCustomerDto responseCustomerDto = customerService.updateCustomer(dto);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer update",responseCustomerDto), HttpStatus.OK
        );
    }

    @DeleteMapping(params = {"customerId"})
    public ResponseEntity<StandardResponse> delete(@RequestParam String customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer delete",null), HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StandardResponse> find(@PathVariable String id){
        System.out.println(id);
        ResponseCustomerDto customer = customerService.findCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(200," find Customer ",customer), HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<StandardResponse> findAll(){
        List<ResponseCustomerDto> customer = customerService.findAllCustomer();
        return new ResponseEntity<>(
                new StandardResponse(200,"All customer ",customer), HttpStatus.OK
        );
    }

    @GetMapping("customer-id/{id}")
    public ResponseEntity<StandardResponse> dtoResponseEntity(@PathVariable String id) {
        ResponseCustomerAndOrderDto responseCustomerAndOrderDto = customerService.responseCustomerAndOrderDto(id);
        return new ResponseEntity<>(
                new StandardResponse(201, "saved", responseCustomerAndOrderDto), HttpStatus.CREATED
        );
    }
}
