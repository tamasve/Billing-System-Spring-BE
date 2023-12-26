package com.billingsystem.service;

import com.billingsystem.entity.Customer;

public interface CustomerService {

    Customer findByEmail(String email);
}
