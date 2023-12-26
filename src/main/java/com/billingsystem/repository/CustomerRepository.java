package com.billingsystem.repository;

import com.billingsystem.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Long> {

    Customer findByEmail(String email);
}
