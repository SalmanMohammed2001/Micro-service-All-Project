package com.example.orderserviceapi.repo;


import com.example.orderserviceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,String> {
    public List<Order> findByCustomerId(String id);
}
