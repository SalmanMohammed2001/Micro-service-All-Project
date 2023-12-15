package com.devstack.com.order.service.api.service.impl;


import com.devstack.com.order.service.api.dto.*;
import com.devstack.com.order.service.api.entity.Order;
import com.devstack.com.order.service.api.feigns.PlacerOrderFeignClient;
import com.devstack.com.order.service.api.feigns.ProductFeignClient;
import com.devstack.com.order.service.api.repo.OrderRepo;
import com.devstack.com.order.service.api.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;


    private final PlacerOrderFeignClient placerOrderFeignClient;

    private final ProductFeignClient productFeignClient;


    public OrderServiceImpl(OrderRepo orderRepo, PlacerOrderFeignClient placerOrderFeignClient, ProductFeignClient productFeignClient) {
        this.orderRepo = orderRepo;
        this.placerOrderFeignClient = placerOrderFeignClient;
        this.productFeignClient = productFeignClient;
    }

    @Override
    public void saveOrder(OrdersDto dto) {
        orderRepo.save(
                new Order(dto.getOrderId(),dto.getCustomerId(),dto.getProductId(),dto.getCost()));

        for(PlaceOrderDto placeOrderDto:dto.getPlaceOrderDtos()){
            ProductDto productDto = productFeignClient.findByProduct(placeOrderDto.getProductId());
            if(productDto.getQtyOnHand()>=placeOrderDto.getQty()){
                productDto.setQtyOnHand(productDto.getQtyOnHand()-placeOrderDto.getQty());
                productFeignClient.createProduct(productDto);
                placerOrderFeignClient.save(placeOrderDto);
            }else {
                throw new RuntimeException("Item Qty Not found");
            }


        }

    }

    @Override
    public ResponseOrderDto getAllOrderByCustomer(long id) {
        List<Order> orderByCustomer = orderRepo.getOrderByCustomer(id);
        ArrayList<OrdersDto> ordersDtos = new ArrayList<>();
        for(Order o:orderByCustomer){
            ordersDtos.add(new OrdersDto(o.getOrderId(),o.getCustomerId(),o.getProductId(),o.getCost(),null));
        }
        return new ResponseOrderDto(ordersDtos);
    }

    @Override
    public ResponseOrderAndPlacerOrderDto findByOrderAndOrderDetails(long id) {
        Order order = orderRepo.findById(id).get();
        OrdersDto ordersDto = new OrdersDto(order.getOrderId(),order.getCustomerId(),order.getProductId(),order.getCost(),null);
        ResponsePlacerOrderDto responsePlacerOrderDto = placerOrderFeignClient.get(ordersDto.getOrderId());
        return new ResponseOrderAndPlacerOrderDto(ordersDto,responsePlacerOrderDto);
    }


}
