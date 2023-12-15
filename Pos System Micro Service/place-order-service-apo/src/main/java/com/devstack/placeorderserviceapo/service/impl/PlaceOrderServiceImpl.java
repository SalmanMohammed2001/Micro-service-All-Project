package com.devstack.placeorderserviceapo.service.impl;

import com.devstack.placeorderserviceapo.dto.PlaceOrderDto;
import com.devstack.placeorderserviceapo.dto.ResponsePlaceOrder;
import com.devstack.placeorderserviceapo.entity.PlaceOrder;
import com.devstack.placeorderserviceapo.repo.PlaceOrderRepo;
import com.devstack.placeorderserviceapo.service.PlaceOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
    private final PlaceOrderRepo placeOrderRepo;

    public PlaceOrderServiceImpl(PlaceOrderRepo placeOrderRepo) {
        this.placeOrderRepo = placeOrderRepo;
    }

    @Override
    public void save(PlaceOrderDto dto) {
        placeOrderRepo.save(
                new PlaceOrder(dto.getId(),dto.getOrderId(),dto.getProductId(),dto.getQty(),dto.getTotal()));
    }

    @Override
    public ResponsePlaceOrder responsePlaceOrder(long id) {
        List<PlaceOrder> byOrderId = placeOrderRepo.findByOrderId(id);
        ArrayList<PlaceOrderDto> placeOrderDtos = new ArrayList<>();
        for(PlaceOrder p:byOrderId){
            placeOrderDtos.add(new PlaceOrderDto(p.getId(),p.getOrderId(),p.getProductId(),p.getQty(),p.getTotal()));
        }

        return new ResponsePlaceOrder(placeOrderDtos);
    }
}
