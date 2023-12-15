package com.example.orderserviceapi.Service.impl;

import com.example.orderserviceapi.Service.OrderService;

import com.example.orderserviceapi.dot.RequestDto.RequestItemDto;
import com.example.orderserviceapi.dot.RequestDto.RequestOrderDto;
import com.example.orderserviceapi.dot.RequestDto.RequestPlaceOrderDto;
import com.example.orderserviceapi.dot.ResponseDto.*;

import com.example.orderserviceapi.dot.ResponseDto.retunCustomerDto.ResponseCustomerOrderDto;
import com.example.orderserviceapi.dot.core.OrderDto;
import com.example.orderserviceapi.entity.Order;
import com.example.orderserviceapi.exception.DuplicateEntryException;
import com.example.orderserviceapi.exception.EntryNotFoundException;
import com.example.orderserviceapi.feigns.PlacerOrderFeignClient;
import com.example.orderserviceapi.feigns.ProductFeignClient;
import com.example.orderserviceapi.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    private final PlacerOrderFeignClient placerOrderFeignClient;

    private final ProductFeignClient productFeignClient;

    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepo orderRepo, PlacerOrderFeignClient placerOrderFeignClient, ProductFeignClient productFeignClient, ModelMapper modelMapper) {
        this.orderRepo = orderRepo;
        this.placerOrderFeignClient = placerOrderFeignClient;
        this.productFeignClient = productFeignClient;
        this.modelMapper = modelMapper;
    }


    @Override
    public void Order(RequestOrderDto dto) {

        if (!orderRepo.existsById(dto.getOrderId())) {
            Order map = modelMapper.map(dto, Order.class);
            orderRepo.save(map);
            for (RequestPlaceOrderDto placeOrderDto : dto.getPlaceOrderDtos()) {
                ResponseItemDto item = productFeignClient.findByItem(placeOrderDto.getProductId());
                System.out.println(item.getItemCode());
                if(item.getQtyOnHand()>=placeOrderDto.getQty()){
                    item.setQtyOnHand(item.getQtyOnHand()- placeOrderDto.getQty());
                    RequestItemDto requestItemDto = modelMapper.map(item, RequestItemDto.class);
                    productFeignClient.update(requestItemDto);
                    placerOrderFeignClient.save(placeOrderDto);
                }else {
                    throw new EntryNotFoundException("item qty not found");
                }



            }
        } else {
            throw new DuplicateEntryException("Duplicate id");
        }


    }

    @Override
    public ResponseOrderAndPlaceOrderDto orderAndPlaceOrder(String id) {
        Order order = orderRepo.findById(id).get();
        ResponseOrderDto responseOrderDto = modelMapper.map(order, ResponseOrderDto.class);
        ResponseOrderPlaceDto responseOrderPlaceDto = placerOrderFeignClient.responseOrderDto(responseOrderDto.getOrderId());
        return new ResponseOrderAndPlaceOrderDto(responseOrderDto,responseOrderPlaceDto);


    }

    @Override
    public ResponseCustomerOrderDto getAllOrderByCustomer(String id) {
        List<Order> byCustomerId = orderRepo.findByCustomerId(id);
        return new ResponseCustomerOrderDto(modelMapper.map(byCustomerId, new TypeToken<List<OrderDto>>() {}.getType()));
    }
}
