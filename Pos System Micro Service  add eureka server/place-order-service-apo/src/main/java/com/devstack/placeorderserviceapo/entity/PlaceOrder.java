package com.devstack.placeorderserviceapo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class PlaceOrder {
    @Id
    private long id;

    private long orderId;

    private  long productId;

    private int qty;

    private double total;
}
