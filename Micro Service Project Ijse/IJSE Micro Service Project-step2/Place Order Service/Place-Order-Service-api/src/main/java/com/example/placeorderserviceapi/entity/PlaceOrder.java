package com.example.placeorderserviceapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class PlaceOrder {
    @Id
    private String id;
    private String orderId;
    private  String productId;
    private int qty;
    private double total;
}
