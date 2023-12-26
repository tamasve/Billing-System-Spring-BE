package com.billingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "prod_id", nullable = false)
    Product product;

    @Column(nullable = false)
    double unit;

}
