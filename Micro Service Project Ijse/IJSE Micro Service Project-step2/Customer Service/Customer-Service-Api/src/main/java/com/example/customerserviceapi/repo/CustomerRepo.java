package com.example.customerserviceapi.repo;

import com.example.customerserviceapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
