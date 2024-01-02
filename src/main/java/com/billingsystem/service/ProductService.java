package com.billingsystem.service;

import com.billingsystem.entity.Product;
import com.billingsystem.entity.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<ProductDTO> findAllWithCatName();
}
