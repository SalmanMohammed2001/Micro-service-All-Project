package com.example.itemserviceapi.Service.impl;


import com.example.itemserviceapi.Service.ItemService;

import com.example.itemserviceapi.dot.RequestDto.RequestItemDto;
import com.example.itemserviceapi.dot.ResponseDto.ResponseItemDto;
import com.example.itemserviceapi.dot.core.ItemDto;
import com.example.itemserviceapi.entity.Item;
import com.example.itemserviceapi.exception.DuplicateEntryException;
import com.example.itemserviceapi.exception.EntryNotFoundException;
import com.example.itemserviceapi.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


    private final ItemRepo itemRepo;

    private final ModelMapper modelMapper;
    public ItemServiceImpl(ItemRepo itemRepo, ModelMapper modelMapper) {
        this.itemRepo = itemRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseItemDto saveItem(RequestItemDto dto) {
        ItemDto itemDto = modelMapper.map(dto, ItemDto.class);
        if(!itemRepo.existsById(dto.getItemCode())){
            Item item = modelMapper.map(itemDto, Item.class);
            return modelMapper.map(itemRepo.save(item),ResponseItemDto.class);
        }else {
            throw new DuplicateEntryException("Duplicate Id");
        }

    }

    @Override
    public ResponseItemDto updateItem(RequestItemDto dto) {
        ItemDto itemDto = modelMapper.map(dto, ItemDto.class);
        if(itemRepo.existsById(dto.getItemCode())){
            Item item = modelMapper.map(itemDto, Item.class);
            return modelMapper.map(itemRepo.save(item),ResponseItemDto.class);
        }else {
            throw new EntryNotFoundException(" Id not found ");
        }
    }

    @Override
    public void deleteItem(String id) {

        if(itemRepo.existsById(id)){
            itemRepo.deleteById(id);
        }else {
            throw new EntryNotFoundException(" Id not found");
        }

    }

    @Override
    public ResponseItemDto findItem(String id) {
        if(itemRepo.existsById(id)) {
            Item item = itemRepo.findById(id).get();
            return modelMapper.map(item, ResponseItemDto.class);
        }else {
            throw new EntryNotFoundException(" Id not found");
        }
    }

    @Override
    public List<ResponseItemDto> findAllItem() {
        List<Item> all = itemRepo.findAll();
        return modelMapper.map(all,new TypeToken<List<ResponseItemDto>>(){}.getType());
    }
}
