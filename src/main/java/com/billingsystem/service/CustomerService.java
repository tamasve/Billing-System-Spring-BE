package com.billingsystem.service;

import com.billingsystem.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer findByEmail(String email);

    List<Customer> findAll();
}
