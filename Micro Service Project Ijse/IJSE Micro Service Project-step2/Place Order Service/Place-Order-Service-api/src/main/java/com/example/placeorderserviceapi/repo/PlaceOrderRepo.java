package com.example.placeorderserviceapi.repo;

import com.example.placeorderserviceapi.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceOrderRepo extends JpaRepository<PlaceOrder,String> {

    public List<PlaceOrder> findByOrderId(String id);

}
