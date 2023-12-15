package com.devstack.com.customer.service.api.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String address;
    private double salary;



}
