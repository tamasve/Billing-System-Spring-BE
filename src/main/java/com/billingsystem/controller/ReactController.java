package com.billingsystem.controller;

import com.billingsystem.entity.Category;
import com.billingsystem.entity.Customer;
import com.billingsystem.entity.Product;
import com.billingsystem.repository.CategoryRepository;
import com.billingsystem.repository.CustomerRepository;
import com.billingsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReactController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String home() {
        return "This is the main page";
    }

    @GetMapping("/cats")
    public List<Category> cats() {
        return categoryRepository.findAll();
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/customers")
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

}
