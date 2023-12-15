package com.example.placeorderserviceapi.service.impl;

import com.example.placeorderserviceapi.dto.RequestDto.RequestPlaceOrderDto;
import com.example.placeorderserviceapi.dto.ResponseDto.ResponseOrderPlaceDto;
import com.example.placeorderserviceapi.dto.ResponseDto.ResponsePlaceOrderDto;
import com.example.placeorderserviceapi.dto.core.PlaceOrderDto;
import com.example.placeorderserviceapi.entity.PlaceOrder;
import com.example.placeorderserviceapi.repo.PlaceOrderRepo;
import com.example.placeorderserviceapi.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
    private final PlaceOrderRepo placeOrderRepo;

    private final ModelMapper modelMapper;

    public PlaceOrderServiceImpl(PlaceOrderRepo placeOrderRepo, ModelMapper modelMapper) {
        this.placeOrderRepo = placeOrderRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(RequestPlaceOrderDto dto) {
        if (placeOrderRepo.existsById(dto.getId())) {
            throw new RuntimeException("duplicate id");
        } else {
            PlaceOrderDto map = modelMapper.map(dto, PlaceOrderDto.class);
            placeOrderRepo.save(modelMapper.map(map, PlaceOrder.class));
        }
    }

    @Override
    public ResponsePlaceOrderDto findPlaceOrder(String id) {
        if(placeOrderRepo.existsById(id)){
            PlaceOrder placeOrder = placeOrderRepo.findById(id).get();
          return  modelMapper.map(placeOrder,ResponsePlaceOrderDto.class);
        }else {
            throw new RuntimeException("id not found");
        }
    }

    @Override
    public ResponseOrderPlaceDto findBYOrderId(String id) {
        List<PlaceOrder> byOrderId = placeOrderRepo.findByOrderId(id);
        List<ResponsePlaceOrderDto> responsePlaceOrderDto= modelMapper.map(byOrderId, new TypeToken<List<ResponsePlaceOrderDto>>() {}.getType());
        return new ResponseOrderPlaceDto(responsePlaceOrderDto);

    }


}
