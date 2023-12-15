package com.devstack.placeorderserviceapo.repo;

import com.devstack.placeorderserviceapo.entity.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceOrderRepo extends JpaRepository<PlaceOrder,Long> {

    public List<PlaceOrder> findByOrderId(long id);
}
