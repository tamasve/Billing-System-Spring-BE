package com.billingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

// a DTO class (Data Transfer Object) to create SQL query using multiple tables from DB

@Data
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private Date date;
    private String cust_name;
    private String prod_name;
    private double price;
    private double unit;

}
