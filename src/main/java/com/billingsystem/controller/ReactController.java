package com.billingsystem.controller;

import com.billingsystem.entity.*;
import com.billingsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReactController {

    private CategoryService categoryService;
    private ProductService productService;
    private CustomerService customerService;
    private OrderService orderService;
    private OrderItemService orderItemService;

    @Autowired
    public ReactController(CategoryService categoryService, ProductService productService, CustomerService customerService,
                           OrderService orderService, OrderItemService orderItemService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.customerService = customerService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @GetMapping("/")
    public String home() {
        return "This is the main page";
    }

    @GetMapping("/cats")
    public List<Category> cats() {
        return categoryService.findAll();
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productService.findAll();
    }

    @GetMapping("/customers")
    public List<Customer> customers() {
        return customerService.findAll();
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public List<OrderDTO> order(@PathVariable Long id) {
        return orderItemService.findAllByOrderId(id);
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<OrderItem> orders() {
        return orderItemService.findAll();
    }

}
