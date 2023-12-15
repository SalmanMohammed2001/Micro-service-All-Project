package com.devstack.com.order.service.api.repo;


import com.devstack.com.order.service.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Long> {


    @Query(nativeQuery = true,value = "SELECT * FROM  orders WHERE customer_id=?1")
   List<Order> getOrderByCustomer(long id);


}
