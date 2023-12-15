package com.example.itemserviceapi.repo;


import com.example.itemserviceapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {
}
