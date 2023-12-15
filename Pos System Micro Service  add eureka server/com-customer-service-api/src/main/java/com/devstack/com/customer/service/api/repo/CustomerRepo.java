package com.devstack.com.customer.service.api.repo;



import com.devstack.com.customer.service.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepo extends JpaRepository<Customer,Long> {



}
