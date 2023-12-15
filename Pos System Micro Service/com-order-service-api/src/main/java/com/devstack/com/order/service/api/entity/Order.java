package com.devstack.com.order.service.api.entity;

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

@Entity(name = "orders")
public class Order {

    @Id
    private long orderId;
    private long customerId;
    private long productId;
    private double cost;
}
