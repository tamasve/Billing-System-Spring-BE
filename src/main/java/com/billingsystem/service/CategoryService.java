package com.billingsystem.service;

import com.billingsystem.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findById(Long id);

    List<Category> findAll();
}
