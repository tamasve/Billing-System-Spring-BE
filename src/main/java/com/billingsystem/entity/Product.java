package com.billingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String unit;

    @Column(nullable = false)
    double price;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    Category category;

    @OneToMany(mappedBy = "product")
    List<Order> orders;

    public Product(String name, String unit, double price, Category category) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
    }
}
