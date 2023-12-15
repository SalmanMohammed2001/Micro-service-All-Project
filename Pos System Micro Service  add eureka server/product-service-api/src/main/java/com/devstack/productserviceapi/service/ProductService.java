package com.devstack.productserviceapi.service;

import com.devstack.productserviceapi.dto.ProductDto;
import com.devstack.productserviceapi.dto.ResponseProductDto;
import com.devstack.productserviceapi.entity.Product;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductDto dto);


    public ProductDto findByProduct(long id);
}
