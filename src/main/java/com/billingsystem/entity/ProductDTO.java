package com.billingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

// a DTO class (Data Transfer Object) to create SQL query using multiple tables from DB

@Data
@AllArgsConstructor
public class ProductDTO {

    private Long product_id;
    private String name;
    private String category;
    private String unit;
    private double price;

}
