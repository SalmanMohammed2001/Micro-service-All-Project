package com.devstack.productserviceapi.api;

import com.devstack.productserviceapi.dto.ProductDto;
import com.devstack.productserviceapi.dto.ResponseProductDto;
import com.devstack.productserviceapi.service.ProductService;
import com.devstack.productserviceapi.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<StandardResponseEntity> createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"product saved!",productDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "get-product-id/{id}")
    public ProductDto findByProduct(@PathVariable long id){
        ProductDto product = productService.findByProduct(id);
        return product;
    }
}

