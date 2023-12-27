package com.billingsystem.controller;

import com.billingsystem.entity.Category;
import com.billingsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReactController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String home() {
        return "This is the main page";
    }

    @GetMapping("/cats")
    public List<Category> cats() {
        return categoryRepository.findAll();
    }

}
