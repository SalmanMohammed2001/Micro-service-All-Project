package com.example.customerserviceapi.Service.impl;

import com.example.customerserviceapi.Service.CustomerService;
import com.example.customerserviceapi.dot.RequestDto.ResponseCustomerDto;
import com.example.customerserviceapi.dot.ResponseDto.RequestCustomerDto;
import com.example.customerserviceapi.dot.ResponseDto.ResponseCustomerAndOrderDto;
import com.example.customerserviceapi.dot.ResponseDto.ResponseCustomerOrderDto;
import com.example.customerserviceapi.dot.core.CustomerDto;
import com.example.customerserviceapi.entity.Customer;
import com.example.customerserviceapi.exception.DuplicateEntryException;
import com.example.customerserviceapi.exception.EntryNotFoundException;
import com.example.customerserviceapi.feigns.OrderFeignsClient;
import com.example.customerserviceapi.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private  final CustomerRepo customerRepo;

    private final OrderFeignsClient orderFeignsClient;

    private final ModelMapper modelMapper;
    public CustomerServiceImpl(CustomerRepo customerRepo, OrderFeignsClient orderFeignsClient, ModelMapper modelMapper) {
        this.customerRepo = customerRepo;
        this.orderFeignsClient = orderFeignsClient;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseCustomerDto saveCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = modelMapper.map(dto, CustomerDto.class);
        if(!customerRepo.existsById(dto.getCustomerId())){
            Customer customer = modelMapper.map(customerDto, Customer.class);
            return modelMapper.map(customerRepo.save(customer),ResponseCustomerDto.class);
        }else {
            throw new DuplicateEntryException("Duplicate Id");
        }

    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = modelMapper.map(dto, CustomerDto.class);
        if(customerRepo.existsById(dto.getCustomerId())){
            Customer customer = modelMapper.map(customerDto, Customer.class);
            return modelMapper.map(customerRepo.save(customer),ResponseCustomerDto.class);
        }else {
            throw new EntryNotFoundException(" Id not found");
        }
    }

    @Override
    public void deleteCustomer(String id) {

        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new EntryNotFoundException(" Id not found");
        }

    }

    @Override
    public ResponseCustomerDto findCustomer(String id) {
        if(customerRepo.existsById(id)) {
            Customer customer = customerRepo.findById(id).get();
            return modelMapper.map(customer, ResponseCustomerDto.class);
        }else {
            throw new EntryNotFoundException(" Id not found");
        }
    }

    @Override
    public List<ResponseCustomerDto> findAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<ResponseCustomerDto>>(){}.getType());
    }

    @Override
    public ResponseCustomerAndOrderDto responseCustomerAndOrderDto(String id) {
        Customer customer = customerRepo.findById(id).get();
        ResponseCustomerDto responseCustomerDto = modelMapper.map(customer, ResponseCustomerDto.class);

        String cid=responseCustomerDto.getCustomerId();
       ResponseCustomerOrderDto responseCustomerDetails = orderFeignsClient.responseCustomerOrderDto(cid);
        return new ResponseCustomerAndOrderDto(responseCustomerDto,responseCustomerDetails);
    }
}
