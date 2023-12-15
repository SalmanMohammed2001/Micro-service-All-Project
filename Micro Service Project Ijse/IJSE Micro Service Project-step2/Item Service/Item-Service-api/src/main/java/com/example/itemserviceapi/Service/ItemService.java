package com.example.itemserviceapi.Service;




import com.example.itemserviceapi.dot.RequestDto.RequestItemDto;
import com.example.itemserviceapi.dot.ResponseDto.ResponseItemDto;

import java.util.List;

public interface ItemService {

    public ResponseItemDto saveItem(RequestItemDto dto);
    public ResponseItemDto  updateItem(RequestItemDto dto);
    public void  deleteItem(String id);
    public ResponseItemDto  findItem(String id);
    public List<ResponseItemDto>  findAllItem();
}
